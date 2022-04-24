package com.example.carrental.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rentals")
public class Rentals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startDate;
    private String endDate;
    private String pickUpTime;
    private String pickUpCity;
    private String dropOffCity;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Clients client;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Cars car;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "rentals_places",
            joinColumns = @JoinColumn(name = "rentals_id"),
            inverseJoinColumns = @JoinColumn(name = "places_id")
    )
    private Set<Places> places = new HashSet<>();
}