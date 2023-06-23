package com.example.carrental.service.impl;

import com.example.carrental.service.RateService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
@Component
public class RateServiceImpl implements RateService {

    private static final String JSON_FORMAT = "?format=json";
    @Value("${nbp.api.rates.url}")
    private String nbpApiUrl;

    @Override
    public BigDecimal getRates(String currency) {
        try {
            final RestTemplate restTemplate = new RestTemplate();
            final String url = nbpApiUrl + currency + JSON_FORMAT;
            final ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            final ObjectMapper mapper = new ObjectMapper();
            final JsonNode rates = mapper.readTree(response.getBody()).path("rates");
            return BigDecimal.valueOf(rates.get(0).path("mid").asDouble());
        } catch (Exception e) {
            log.error("Exception while getting rates for currency: {}", currency, e);
            return BigDecimal.ZERO;
        }
    }
}
