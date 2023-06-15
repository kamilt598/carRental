package com.example.carrental.service;

import java.math.BigDecimal;

public interface RateService {

    BigDecimal getRates(String currency);
}
