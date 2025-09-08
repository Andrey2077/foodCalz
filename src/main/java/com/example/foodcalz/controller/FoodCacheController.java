package com.example.foodcalz.controller;


import com.example.foodcalz.dto.SimpleCacheDataResponse;
import com.example.foodcalz.service.utils.cache.FoodCacheCleanServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/foodcache")
@RequiredArgsConstructor
public class FoodCacheController {


    private final FoodCacheCleanServiceImpl foodSimpleCacheCleanService;

    @Operation(summary = "Очистка кэша")
    @DeleteMapping("/clear")
    @ApiResponse(responseCode = "200", description = "Кэш очищен")
    public ResponseEntity<SimpleCacheDataResponse> clearCache(){
        return new ResponseEntity<>(foodSimpleCacheCleanService.clearCache(),HttpStatus.OK);
    }

}
