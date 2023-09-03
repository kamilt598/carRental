package com.example.carrental.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "car-rental.endpoint")
@Setter
@Getter
public class Endpoints {
    private String home;
    private String about;
    private String services;
    private String login;
    private String logout;
    private String register;
    private String myRentals;
    private String myAccount;
    private String editAccount;
    private String editAccountByAdmin;
    private String carSelection;
    private String carDetails;
    private String cars;
    private String maintenance;
    private String rentalManagement;
    private String accountManagement;
    private String placeManagement;
    private String carManagement;
    private String deleteAccount;
    private String deletePlace;
    private String deleteCar;
    private String editCar;
    private String contact;

    public String[] getAuthenticated() {
        return new String[]{carSelection, myAccount, editAccount, myRentals};
    }

    public String[] getAdminOnly() {
        return new String[]{maintenance, editAccountByAdmin, rentalManagement, accountManagement, carManagement,
                placeManagement, deletePlace, deleteCar, editCar};
    }
}
