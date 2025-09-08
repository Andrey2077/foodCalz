package com.example.foodcalz.service.data;


import lombok.RequiredArgsConstructor;
import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.mapper.FoodMapper;
import com.example.foodcalz.service.jpa.JpaFoodSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DataFoodSearchServiceServiceImpl implements DataFoodSearchService {

    private final JpaFoodSearchService jpaFoodSearchService;
    private final FoodMapper foodMapper;

    @Override
    @Cacheable(value = "FoodDataResponse", key = "#id")
    public FoodDataResponse byId(Long id) {
        log.info("Метод byId сработал");
        return foodMapper.toDataResponse(jpaFoodSearchService.byId(id));
    }

    @Override
    public List<FoodDataResponse> byAll() {
        return jpaFoodSearchService.byAll()
                .stream()
                .map(x -> foodMapper.toDataResponse(x))
                .collect(Collectors.toList());
    }
}
