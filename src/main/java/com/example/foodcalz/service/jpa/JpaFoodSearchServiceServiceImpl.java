package com.example.foodcalz.service.jpa;

import com.example.foodcalz.repository.FoodJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.foodcalz.entity.FoodEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaFoodSearchServiceServiceImpl implements JpaFoodSearchService {

    private final FoodJpaRepository foodJpaRepository;

    @Override
    public FoodEntity byId(Long id) {
        return foodJpaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Food not found by id:" + id));
    }

    @Override
    public List<FoodEntity> byAll() {
        return foodJpaRepository.findAll();
    }
}
