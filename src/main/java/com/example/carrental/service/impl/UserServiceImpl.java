package com.example.carrental.service.impl;

import com.example.carrental.dto.UserDto;
import com.example.carrental.mapper.UserMapper;
import com.example.carrental.model.User;
import com.example.carrental.repository.RentalRepository;
import com.example.carrental.repository.UserRepository;
import com.example.carrental.service.UserDataValidator;
import com.example.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "car-rental.endpoint")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RentalRepository rentalRepository;
    private final UserDataValidator userDataValidator;
    @Setter
    private String register;
    @Setter
    private String home;
    @Setter
    private String myAccount;
    @Setter
    private String logout;
    @Setter
    private String login;
    @Setter
    private String editAccount;

    public RedirectView registerUser(User user) {
        userDataValidator.validateUserData(user.getNick(), user.getPhoneNumber(), user.getEmail(), user, register);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new RedirectView(login);
    }

    @Override
    public String getAccount(String nickname, Model model) {
        final User user = userRepository.findByNick(nickname)
                .orElseThrow(userDataValidator.handleIfUserCouldNotBeFound(nickname, home));
        model.addAttribute("user", UserMapper.mapToDto(user));
        return "account";
    }

    @Override
    public String editAccount(String nickname, Model model) {
        final User user = userRepository.findByNick(nickname)
                .orElseThrow(userDataValidator.handleIfUserCouldNotBeFound(nickname, myAccount));
        model.addAttribute("user", UserMapper.mapToDto(user));
        return "editAccount";
    }

    @Override
    public RedirectView saveAccount(String nickname, UserDto userDto, String password, RedirectAttributes redirectAttributes) {
        final User user = getUserAndValidate(nickname, userDto);
        updateAndSaveUserData(user, userDto, password);
        redirectAttributes.addFlashAttribute("user", userDto);
        return new RedirectView(myAccount, true);
    }

    @Override
    @Transactional
    public RedirectView deleteAccount(String nickname) {
        final User user = userRepository.findByNick(nickname)
                .orElseThrow(userDataValidator.handleIfUserCouldNotBeFound(nickname, myAccount));
        rentalRepository.deleteByUserId(user);
        userRepository.delete(user);
        return new RedirectView(logout);
    }

    private User getUserAndValidate(String nickname, UserDto userDto) {
        final User user = userRepository.findByNick(nickname)
                .orElseThrow(userDataValidator.handleIfUserCouldNotBeFound(nickname, editAccount));
        userDataValidator.compareUserDataAndValidate(user, userDto, editAccount);
        return user;
    }

    private void updateAndSaveUserData(User user, UserDto userDto, String password) {
        user.setNick(userDto.getNick());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        if (password != null) {
            user.setPassword(passwordEncoder.encode(password));
        }
        userRepository.save(user);
    }
}
