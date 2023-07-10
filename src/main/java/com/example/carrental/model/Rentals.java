package com.example.carrental.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "rentals")
@AllArgsConstructor
public class Rentals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "pick_up_place_id")
    private Places pickUpCity;
    @ManyToOne
    @JoinColumn(name = "drop_off_place_id")
    private Places dropOffCity;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Cars carId;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients clientId;
}
