package com.example.carrental.service;

import org.springframework.ui.Model;
import org.springframework.web.servlet.view.RedirectView;

public interface PlaceService {

    String getPlacesMaintenanceView(Model model);

    RedirectView createPlace(String city);

    RedirectView deletePlace(String city);
}
