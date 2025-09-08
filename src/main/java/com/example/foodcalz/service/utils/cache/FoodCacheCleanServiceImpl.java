package com.example.foodcalz.service.utils.cache;


import com.example.foodcalz.dto.SimpleCacheDataResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class FoodCacheCleanServiceImpl implements FoodCacheCleanService {

    private final CacheManager cacheManager;

    @Override
     public SimpleCacheDataResponse clearCache() {
        cacheManager.getCache("FoodDataResponse").clear();
        log.info("Кэш почищен");
        return new SimpleCacheDataResponse("Кэш почищен");
    }


}
