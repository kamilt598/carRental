package com.example.carrental.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class CarDto {
    private Long id;
    private String brand;
    private String model;
    private String type;
    private String productionYear;
    private String engine;
    private String color;
    private Boolean isRented;
    private String picture;
    private BigDecimal price;
    private String location;
    private BigDecimal priceEur;
    private BigDecimal priceUsd;
}
