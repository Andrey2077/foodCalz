package com.example.foodcalz.service.utils.cache;

import com.example.foodcalz.dto.SimpleCacheDataResponse;

public interface FoodCacheCleanService {

    SimpleCacheDataResponse clearCache();

    SimpleCacheDataResponse clearById(Long id);

}
