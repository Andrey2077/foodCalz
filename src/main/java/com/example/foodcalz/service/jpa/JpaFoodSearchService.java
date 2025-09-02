package com.example.foodcalz.service.jpa;

import com.example.foodcalz.entity.FoodEntity;
import com.example.foodcalz.exception.FoodNotFoundException;

import java.util.List;

public interface JpaFoodSearchService {

   FoodEntity byId(Long id) throws FoodNotFoundException;

   List<FoodEntity> byAll();
}
