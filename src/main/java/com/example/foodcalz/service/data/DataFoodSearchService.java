package com.example.foodcalz.service.data;

import com.example.foodcalz.dto.FoodDataResponse;

import java.util.List;

public interface DataFoodSearchService {

    FoodDataResponse byId(Long id);
    List<FoodDataResponse> byAll();

}
