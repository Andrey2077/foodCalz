package com.example.foodcalz.dto;

import jakarta.persistence.*;
import lombok.Data;
import com.example.foodcalz.entity.FoodEntity;

@Data
public class FoodDataResponse {
    private Long id;
    private String name;
    private String brand;
    private int kcal;
    private int protein;
    private int fat;
    private int carbs;
}
