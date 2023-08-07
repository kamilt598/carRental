package com.example.carrental.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String type;
    private String productionYear;
    private String engine;
    private String color;
    private String picture;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
}
