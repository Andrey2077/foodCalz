package com.example.foodcalz.repository;

import com.example.foodcalz.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodJpaRepository extends JpaRepository<FoodEntity, Long> {
}
