package com.example.carrental.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Cars {

    @Id
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
    private BigDecimal priceUSD;
    private BigDecimal priceEUR;
    private String location;
}
