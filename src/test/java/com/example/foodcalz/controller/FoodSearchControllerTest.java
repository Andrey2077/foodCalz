package com.example.foodcalz.controller;

import com.example.foodcalz.dto.FoodDataResponse;
import com.example.foodcalz.service.data.DataFoodSearchService;
import com.example.foodcalz.service.data.DataFoodSearchServiceServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class FoodSearchControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    private DataFoodSearchServiceServiceImpl dataFoodSearchService;

    private FoodDataResponse food1;
    private FoodDataResponse food2;

    @BeforeEach
    void setUp() {
        food1 = new FoodDataResponse();
        food1.setId(1L);
        food1.setName("Огурец");
        food1.setBrand("Садовод");
        food1.setKcal(15);
        food1.setProtein(1);
        food1.setFat(0);
        food1.setCarbs(3);

        food2 = new FoodDataResponse();
        food2.setId(1L);
        food2.setName("Яблоко");
        food2.setBrand("Природа");
        food2.setKcal(52);
        food2.setProtein(0);
        food2.setFat(0);
        food2.setCarbs(14);


    }



    @Test
    void getByIdSuccess() throws Exception {
        when(dataFoodSearchService.byId(1L)).thenReturn(food1);
        when(dataFoodSearchService.byId(2L)).thenReturn(food2);

        mockMvc.perform(get("/api/v1/food/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Огурец"))
            .andExpect(jsonPath("$.brand").value("Садовод"))
            .andExpect(jsonPath("$.kcal").value(15))
            .andExpect(jsonPath("$.protein").value(1))
            .andExpect(jsonPath("$.fat").value(0))
            .andExpect(jsonPath("$.carbs").value(3));

    }

    @Test
    void getByIdNotFound() throws Exception {
        when(dataFoodSearchService.byId(3L)).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Food not found"));

        mockMvc.perform(get("/api/v1/food/{id}", 3L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    void getAllSuccess() throws Exception {
        when(dataFoodSearchService.byAll()).thenReturn(List.of(food1, food2));

        mockMvc.perform(get("/api/v1/food")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].name", is("Огурец")))
                .andExpect(jsonPath("$[1].name", is("Яблоко")));


    }

    @Test
    void getAllEmpty() throws Exception {
        when(dataFoodSearchService.byAll()).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Food is not exist"));

        mockMvc.perform(get("/api/v1/food")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

}