package com.example.carrental.scheduler;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CleanRatesCacheSchedulerTest extends TestSpecification {

    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private CleanRatesCacheScheduler cleanRatesCacheScheduler;

    @Test
    void cleanRatesCache() {
        cleanRatesCacheScheduler.cleanRatesCache();
        assertEquals(Collections.emptyMap(), cacheManager.getCache("currencyRate").getNativeCache());
    }
}