package com.example.carrental.controller.maintenance;

import com.example.carrental.dto.UserDto;
import com.example.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccountManagementController {

    private final UserService userService;

    @GetMapping(value = "${car-rental.endpoint.accountManagement}")
    public String getAccountManagement(Model model) {
        return userService.getAccounts(model);
    }

    @GetMapping(value = "${car-rental.endpoint.editAccountByAdmin}")
    public String editAccount(Model model, @PathVariable String userNickname) {
        return userService.editAccount(userNickname, model, true);
    }

    @PostMapping(value = "${car-rental.endpoint.editAccountByAdmin}")
    public RedirectView saveAccount(@PathVariable String userNickname, UserDto userDto, String password) {
        return userService.saveAccount(userNickname, userDto, password, null, true);
    }

    @GetMapping(value = "${car-rental.endpoint.deleteAccount}")
    public RedirectView deleteAccount(@PathVariable String userNickname) {
        return userService.deleteAccount(userNickname, true);
    }
}
