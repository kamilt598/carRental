package com.example.carrental.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "places")
public class Places {
    @Id
    private Long id;
    private String city;
}
