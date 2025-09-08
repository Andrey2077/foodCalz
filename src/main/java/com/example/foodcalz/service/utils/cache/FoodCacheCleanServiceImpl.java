package com.example.foodcalz.service.utils.cache;


import com.example.foodcalz.dto.SimpleCacheDataResponse;
import com.example.foodcalz.entity.FoodEntity;
import com.example.foodcalz.service.jpa.JpaFoodSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class FoodCacheCleanServiceImpl implements FoodCacheCleanService {

    private final CacheManager cacheManager;
    private final JpaFoodSearchService jpaFoodSearchService;

    @Override
     public SimpleCacheDataResponse clearCache() {
        cacheManager.getCache("FoodDataResponse").clear();
        log.info("Кэш почищен");
        return new SimpleCacheDataResponse("Cache is clear");
    }

    @Override
    public SimpleCacheDataResponse clearById(Long id) {
        Cache cache = cacheManager.getCache("FoodDataResponse");
        if (cache != null) {
            cache.evict(id);
            log.info("Delete element with key: " + id);
            return new SimpleCacheDataResponse("Cache is clear by id: " + id);
        } else {
            return new SimpleCacheDataResponse("Couldn't find element with id: " + id);
        }

    }


}
