package com.example.carrental.controller.maintenance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MaintenanceController {

    @GetMapping(value = "${car-rental.endpoint.maintenance}")
    public String getMaintenanceView() {
        return "admin/maintenance";
    }
}
