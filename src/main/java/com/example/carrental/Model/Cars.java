package com.example.carrental.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String type;
    private String year;
    private String engine;
    private String color;
    private boolean isRented;
    private String picture;
    private String price;
    private String location;

    @OneToMany(mappedBy = "car")
    private Set<Rentals> rentals;

}
