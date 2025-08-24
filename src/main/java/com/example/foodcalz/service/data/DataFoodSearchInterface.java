package com.example.foodcalz.service.data;

import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.entity.FoodEntity;

import java.util.List;

public interface DataFoodSearchInterface {

    FoodDataResponse byId(String id);
    List<FoodDataResponse> byAll();

}
