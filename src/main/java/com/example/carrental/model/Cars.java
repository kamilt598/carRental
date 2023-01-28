package com.example.carrental.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private String location;
}
