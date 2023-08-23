package com.example.carrental.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
public class CleanRatesCacheScheduler {

    @Scheduled(fixedRateString = "${cache.rates.ttl}")
    @CacheEvict(value = "currencyRate", allEntries = true)
    public void cleanRatesCache() {
        log.info("Cleaning rates cache");
    }
}
