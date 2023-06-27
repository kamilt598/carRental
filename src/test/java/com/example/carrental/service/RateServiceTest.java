package com.example.carrental.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RateServiceTest {

    @Autowired
    private RateService rateService;

    @Test
    void getRates() {
        assertThat(rateService.getRate("USD"))
                .isNotZero()
                .isNotNull();
    }

    @Test
    void handleExceptionWhileGettingRates() throws JsonProcessingException {
        assertThat(rateService.getRate(null))
                .isEqualTo(BigDecimal.ZERO)
                .isNotNull();
    }
}