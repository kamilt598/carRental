package com.example.carrental.controller.maintenance;

import com.example.carrental.TestSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class MaintenanceControllerTest extends TestSpecification {

    @Test
    void getMaintenanceView() throws Exception {
        mockMvc.perform(get(endpoints.getMaintenance()))
                .andExpect(view().name("admin/maintenance"))
                .andExpect(status().isOk());
    }
}