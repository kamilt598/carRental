package com.example.carrental.service;

import org.springframework.cache.annotation.Cacheable;

import java.math.BigDecimal;

@FunctionalInterface
public interface RateService {

    @Cacheable("currencyRate")
    BigDecimal getRate(String currency);
}
