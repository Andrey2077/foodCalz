package com.example.foodcalz.service.data;

import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.exception.FoodDtoCreationException;
import com.example.foodcalz.exception.FoodNotFoundException;

import java.util.List;

public interface DataFoodSearchService {

    FoodDataResponse byId(Long id) throws FoodDtoCreationException, FoodNotFoundException;
    List<FoodDataResponse> byAll();

}
