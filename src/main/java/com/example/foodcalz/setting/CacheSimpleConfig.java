package com.example.foodcalz.setting;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableCaching
@Profile("simple")
public class CacheSimpleConfig {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("FoodDataResponse");
    }

}
