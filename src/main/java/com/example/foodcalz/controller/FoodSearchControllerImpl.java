package com.example.foodcalz.controller;


import com.example.foodcalz.dto.FoodDataRequest;
import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.exception.FoodDtoCreationException;
import com.example.foodcalz.exception.FoodNotFoundException;
import com.example.foodcalz.service.data.DataFoodSearchServiceServiceImpl;
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
@RequestMapping("api/v1/food")
@RequiredArgsConstructor
public class FoodSearchControllerImpl implements FoodSearchController{

    private final DataFoodSearchServiceServiceImpl foodService;


    @Override
    public ResponseEntity<FoodDataResponse> handleRequestById(Long id) throws FoodNotFoundException, FoodDtoCreationException {
        FoodDataRequest data = new FoodDataRequest(id);
        return new ResponseEntity<>(foodService.byId(data.getId()), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<FoodDataResponse>> handleRequestByAll() {
        return new ResponseEntity<>(foodService.byAll(), HttpStatus.OK);
    }

}
