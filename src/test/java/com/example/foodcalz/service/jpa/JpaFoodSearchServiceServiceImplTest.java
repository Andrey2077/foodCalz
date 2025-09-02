package com.example.foodcalz.service.jpa;

import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.entity.FoodEntity;
import com.example.foodcalz.exception.FoodDtoCreationException;
import com.example.foodcalz.exception.FoodNotFoundException;
import com.example.foodcalz.mapper.FoodMapper;
import com.example.foodcalz.repository.FoodJpaRepository;
import com.example.foodcalz.service.data.DataFoodSearchServiceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

class JpaFoodSearchServiceServiceImplTest {


    @Mock
    private FoodJpaRepository foodJpaRepository;

    @InjectMocks
    private JpaFoodSearchServiceServiceImpl jpaFoodSearchService;

    private FoodEntity foodEntity1;
    private FoodEntity foodEntity2;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

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
        when(foodJpaRepository.findById(1L)).thenReturn(Optional.ofNullable(foodEntity1));
        when(foodJpaRepository.findById(2L)).thenReturn(Optional.ofNullable(foodEntity2));

        FoodEntity testFoodEntity1 = jpaFoodSearchService.byId(1L);
        FoodEntity testFoodEntity2 = jpaFoodSearchService.byId(2L);

        assertEquals(foodEntity1, testFoodEntity1);
        assertEquals(foodEntity2, testFoodEntity2);
        verify(foodJpaRepository, times(1)).findById(1L);
        verify(foodJpaRepository, times(1)).findById(2L);
    }

    @Test
    void getFoodByIdNotFound() {
        when(foodJpaRepository.findById(3L)).thenReturn(Optional.empty());

        assertThrows(FoodNotFoundException.class, () -> jpaFoodSearchService.byId(3L));
    }

    @Test
    void getFoodByAllSuccess() {
        List<FoodEntity> listResult = List.of(foodEntity1, foodEntity2);
        when(foodJpaRepository.findAll()).thenReturn(listResult);

        List<FoodEntity> result = jpaFoodSearchService.byAll();

        assertEquals(2, result.size());
        assertEquals("Огурец", result.get(0).getName());
        assertEquals("Яблоко", result.get(1).getName());

        verify(foodJpaRepository, times(1)).findAll();

    }

    @Test
    void getFoodByAllEmpty() {
        when(foodJpaRepository.findAll()).thenReturn(Collections.emptyList());
        List<FoodEntity> actual = jpaFoodSearchService.byAll();
        assertTrue(actual.isEmpty(), "Ожидался пустой список продуктов");
        verify(foodJpaRepository, times(1)).findAll();

    }


}