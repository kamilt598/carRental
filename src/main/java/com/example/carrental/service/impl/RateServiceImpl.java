package com.example.carrental.service.impl;

import com.example.carrental.service.RateService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${nbp.api.rates.url}")
    private String nbpApiUrl;

    @Override
    public BigDecimal getRate(String currency) {
        try {
            final JsonNode rate = getRateFromNBP(currency);
            return BigDecimal.valueOf(rate.get(0).path("mid").asDouble());
        } catch (Exception e) {
            log.error("Exception while getting rates for currency: {}", currency, e);
            return BigDecimal.ZERO;
        }
    }

    public JsonNode getRateFromNBP(String currency) throws JsonProcessingException {
        final URI uri = buildUri(currency);
        final ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        return objectMapper.readTree(response.getBody()).path("rates");
    }

    public URI buildUri(String currency) {
        return UriComponentsBuilder.fromUriString(nbpApiUrl)
                .queryParam("format", "json")
                .buildAndExpand(Map.of("currency", currency))
                .toUri();
    }
}
