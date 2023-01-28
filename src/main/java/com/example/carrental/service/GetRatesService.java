package com.example.carrental.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Slf4j
public class GetRatesService {

    public static BigDecimal getRates(String currency) {
        try {
            final RestTemplate restTemplate = new RestTemplate();
            final String url
                    = "https://api.nbp.pl/api/exchangerates/rates/a/" + currency + "?format=json";
            final ResponseEntity<String> response
                    = restTemplate.getForEntity(url, String.class);
            final ObjectMapper mapper = new ObjectMapper();
            final JsonNode rates = mapper.readTree(response.getBody()).path("rates");
            return BigDecimal.valueOf(rates.get(0).path("mid").asDouble());
        } catch (Exception e) {
            log.error("Exception while mapping response", e);
            return BigDecimal.ZERO;
        }
    }
}
