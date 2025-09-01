package com.example.foodcalz.mapper;

import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.entity.FoodEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-30T19:41:04+0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class FoodMapperImpl implements FoodMapper {

    @Override
    public FoodDataResponse toDataResponse(FoodEntity transaction) {
        if ( transaction == null ) {
            return null;
        }

        FoodDataResponse foodDataResponse = new FoodDataResponse();

        foodDataResponse.setId( transaction.getId() );
        foodDataResponse.setName( transaction.getName() );
        foodDataResponse.setBrand( transaction.getBrand() );
        foodDataResponse.setKcal( transaction.getKcal() );
        foodDataResponse.setProtein( transaction.getProtein() );
        foodDataResponse.setFat( transaction.getFat() );
        foodDataResponse.setCarbs( transaction.getCarbs() );

        return foodDataResponse;
    }

    @Override
    public FoodEntity toEntity(FoodDataResponse foodDataResponse) {
        if ( foodDataResponse == null ) {
            return null;
        }

        FoodEntity foodEntity = new FoodEntity();

        foodEntity.setId( foodDataResponse.getId() );
        foodEntity.setName( foodDataResponse.getName() );
        foodEntity.setBrand( foodDataResponse.getBrand() );
        foodEntity.setKcal( foodDataResponse.getKcal() );
        foodEntity.setProtein( foodDataResponse.getProtein() );
        foodEntity.setFat( foodDataResponse.getFat() );
        foodEntity.setCarbs( foodDataResponse.getCarbs() );

        return foodEntity;
    }
}
