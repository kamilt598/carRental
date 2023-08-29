package com.example.carrental.controller;

import com.example.carrental.dto.UserDto;
import com.example.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccountController {

    private final UserService userService;

    @GetMapping(value = "${car-rental.endpoint.myAccount}")
    public String getAccount(Principal principal, Model model) {
        return userService.getAccountByNickname(principal.getName(), model);
    }

    @GetMapping(value = "${car-rental.endpoint.editAccount}")
    public String editAccount(Principal principal, Model model) {
        return userService.editAccount(principal.getName(), model, false);
    }

    @PostMapping(value = "${car-rental.endpoint.editAccount}")
    public RedirectView saveAccount(Principal principal, UserDto userDto, String password, RedirectAttributes redirectAttributes) {
        return userService.saveAccount(principal.getName(), userDto, password, redirectAttributes, false);
    }

    @PostMapping(value = "${car-rental.endpoint.myAccount}")
    public RedirectView deleteAccount(Principal principal) {
        return userService.deleteAccount(principal.getName(), false);
    }
}
