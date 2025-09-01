package com.example.foodcalz.controller;

import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.exception.FoodDtoCreationException;
import com.example.foodcalz.exception.FoodNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FoodSearchController {


    @Operation(summary = "Поиск продукта по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Продукт найден"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
            @ApiResponse(responseCode = "404", description = "Продукт не найден")
    })
    @GetMapping("/{id}")
    ResponseEntity<FoodDataResponse> handleRequestById(
            @Parameter(description = "ID продукта", required = true)
            @PathVariable Long id) throws FoodNotFoundException, FoodDtoCreationException;

    @Operation(summary = "Получить список всех продуктов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список успешно получен"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос")
    })
    @GetMapping("")
    ResponseEntity<List<FoodDataResponse>> handleRequestByAll();
}
