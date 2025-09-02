package com.example.foodcalz.service.data;


import com.example.foodcalz.exception.FoodDtoCreationException;
import com.example.foodcalz.exception.FoodNotFoundException;
import lombok.RequiredArgsConstructor;
import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.mapper.FoodMapper;
import com.example.foodcalz.service.jpa.JpaFoodSearchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataFoodSearchServiceServiceImpl implements DataFoodSearchService {

    private final JpaFoodSearchService jpaFoodSearchService;
    private final FoodMapper foodMapper;

    @Override
    public FoodDataResponse byId(Long id) throws FoodDtoCreationException, FoodNotFoundException {
        try {
            return foodMapper.toDataResponse(jpaFoodSearchService.byId(id));
        } catch (FoodNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new FoodDtoCreationException("Ошибка при создании DTO");
        }

    }

    @Override
    public List<FoodDataResponse> byAll() {
        return jpaFoodSearchService.byAll()
                .stream()
                .map(x -> foodMapper.toDataResponse(x))
                .collect(Collectors.toList());
    }
}
