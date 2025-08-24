package com.example.foodcalz.mapper;


import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.entity.FoodEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    FoodDataResponse toDataResponse(FoodEntity transaction);

    FoodEntity toEntity(FoodDataResponse foodDataResponse);

}
