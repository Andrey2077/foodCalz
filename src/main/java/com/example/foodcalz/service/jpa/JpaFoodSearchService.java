package com.example.foodcalz.service.jpa;

import com.example.foodcalz.entity.FoodEntity;

import java.util.List;

public interface JpaFoodSearchService {

   FoodEntity byId(Long id);

   List<FoodEntity> byAll();
}
