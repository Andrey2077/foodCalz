package com.example.foodcalz.controller;


import com.example.foodcalz.dto.FoodDataRequest;
import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.service.data.DataFoodSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/searchfood")
@RequiredArgsConstructor
public class FoodSearchController {

    private final DataFoodSearchService foodService;

    @Operation(summary = "Поиск продукта по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Продукт найден"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос"),
            @ApiResponse(responseCode = "404", description = "Продукт не найден")
    })

    @PostMapping("/byId")
    public ResponseEntity<FoodDataResponse> handleRequestById(
            @Parameter(description = "ID продукта", required = true)
            @RequestBody FoodDataRequest data) {
        return new ResponseEntity<>(foodService.byId(data.getId()), HttpStatus.OK);
    }

    @Operation(summary = "Получить список всех продуктов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список успешно получен"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос")
    })
    @GetMapping("")
    public ResponseEntity<List<FoodDataResponse>> handleRequestByAll() {
        return new ResponseEntity<>(foodService.byAll(), HttpStatus.OK);
    }

}
