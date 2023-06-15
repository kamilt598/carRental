package com.example.carrental.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rentals")
public class Rentals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startDate;
    private String endDate;
    private String pickUpCity;
    private String dropOffCity;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Cars carId;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients clientId;
}
