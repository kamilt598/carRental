package com.example.carrental.Model;

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
    private Long id;
    private String startDate;
    private String endDate;
    private String pickUpTime;
    private String pickUpCity;
    private String dropOffCity;
    private Long clientId;
    private Long carId;
    private Long placeId;
}