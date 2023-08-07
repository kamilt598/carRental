package com.example.carrental.service;

import com.example.carrental.dto.UserDto;
import com.example.carrental.model.User;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

public interface UserService {

    RedirectView register(User user, RedirectAttributes redirectAttributes);

    String getAccount(String nickname, Model model);

    String editAccount(String nickname, Model model);

    RedirectView saveAccount(String nickname, UserDto userDto, String password, RedirectAttributes redirectAttributes);

    RedirectView deleteAccount(String nickname);
}
