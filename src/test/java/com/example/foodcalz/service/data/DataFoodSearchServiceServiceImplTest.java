package com.example.foodcalz.service.data;

import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.entity.FoodEntity;
import com.example.foodcalz.exception.FoodDtoCreationException;
import com.example.foodcalz.exception.FoodNotFoundException;
import com.example.foodcalz.mapper.FoodMapper;
import com.example.foodcalz.service.jpa.JpaFoodSearchService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DataFoodSearchServiceServiceImplTest {


    @Mock
    private JpaFoodSearchService jpaFoodSearchService;

    @Mock
    private FoodMapper foodMapper;

    @InjectMocks
    DataFoodSearchServiceServiceImpl dataFoodSearchService;

    private FoodDataResponse foodDataResponse1;
    private FoodDataResponse foodDataResponse2;

    private FoodEntity foodEntity1;
    private FoodEntity foodEntity2;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        foodDataResponse1 = new FoodDataResponse();
        foodDataResponse1.setId(1L);
        foodDataResponse1.setName("Огурец");
        foodDataResponse1.setBrand("Садовод");
        foodDataResponse1.setKcal(15);
        foodDataResponse1.setProtein(1);
        foodDataResponse1.setFat(0);
        foodDataResponse1.setCarbs(3);

        foodDataResponse2 = new FoodDataResponse();
        foodDataResponse2.setId(1L);
        foodDataResponse2.setName("Яблоко");
        foodDataResponse2.setBrand("Природа");
        foodDataResponse2.setKcal(52);
        foodDataResponse2.setProtein(0);
        foodDataResponse2.setFat(0);
        foodDataResponse2.setCarbs(14);

        foodEntity1 = new FoodEntity();
        foodEntity1.setId(1L);
        foodEntity1.setName("Огурец");
        foodEntity1.setBrand("Садовод");
        foodEntity1.setKcal(15);
        foodEntity1.setProtein(1);
        foodEntity1.setFat(0);
        foodEntity1.setCarbs(3);

        foodEntity2 = new FoodEntity();
        foodEntity2.setId(1L);
        foodEntity2.setName("Яблоко");
        foodEntity2.setBrand("Природа");
        foodEntity2.setKcal(52);
        foodEntity2.setProtein(0);
        foodEntity2.setFat(0);
        foodEntity2.setCarbs(14);
    }

    @Test
    void getFoodByIdSuccess() throws FoodNotFoundException, FoodDtoCreationException {
        when(jpaFoodSearchService.byId(1L)).thenReturn(foodEntity1);
        when(jpaFoodSearchService.byId(2L)).thenReturn(foodEntity2);
        when(foodMapper.toDataResponse(foodEntity1)).thenReturn(foodDataResponse1);
        when(foodMapper.toDataResponse(foodEntity2)).thenReturn(foodDataResponse2);

        FoodDataResponse foodDataResponseTest1 = dataFoodSearchService.byId(1L);
        FoodDataResponse foodDataResponseTest2 = dataFoodSearchService.byId(2L);

        assertNotNull(foodDataResponseTest1);
        assertNotNull(foodDataResponseTest2);
        assertEquals(foodDataResponse1, foodDataResponseTest1);
        assertEquals(foodDataResponse2, foodDataResponseTest2);

        verify(jpaFoodSearchService).byId(1L);
        verify(jpaFoodSearchService).byId(2L);
        verify(foodMapper).toDataResponse(foodEntity1);
        verify(foodMapper).toDataResponse(foodEntity2);
    }

    @Test
    void getFoodByIdNotFoundException() throws FoodNotFoundException {
        when(jpaFoodSearchService.byId(3L)).thenThrow(new FoodNotFoundException("Food not found by id"));
        FoodNotFoundException exception = assertThrows(
                FoodNotFoundException.class,
                () -> dataFoodSearchService.byId(3L)
        );
    }

    @Test
    void getFoodByIdDtoCreationException() throws FoodNotFoundException {
        when(jpaFoodSearchService.byId(1L)).thenReturn(foodEntity1);
        when(foodMapper.toDataResponse(foodEntity1)).thenThrow(new RuntimeException(""));
        FoodDtoCreationException exception = assertThrows(
                FoodDtoCreationException.class,
                () -> dataFoodSearchService.byId(1L)
        );
    }

    @Test
    void getFoodByAllSuccess() {
        List<FoodEntity> foodEntities = List.of(foodEntity1, foodEntity2);
        List<FoodDataResponse> expectedResponses = List.of(foodDataResponse1, foodDataResponse2);

        when(jpaFoodSearchService.byAll()).thenReturn(foodEntities);
        when(foodMapper.toDataResponse(foodEntity1)).thenReturn(foodDataResponse1);
        when(foodMapper.toDataResponse(foodEntity2)).thenReturn(foodDataResponse2);

        List<FoodDataResponse> result = dataFoodSearchService.byAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(expectedResponses, result);

        verify(jpaFoodSearchService, times(1)).byAll();
        verify(foodMapper, times(1)).toDataResponse(foodEntity1);
        verify(foodMapper, times(1)).toDataResponse(foodEntity2);

    }

    @Test
    void getFoodByAllEmpty() {
        when(jpaFoodSearchService.byAll()).thenReturn(List.of());

        List<FoodDataResponse> result = dataFoodSearchService.byAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(jpaFoodSearchService).byAll();
        verifyNoInteractions(foodMapper);
    }
}