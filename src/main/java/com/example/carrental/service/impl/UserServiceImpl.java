package com.example.carrental.service.impl;

import com.example.carrental.dto.UserDto;
import com.example.carrental.mapper.UserMapper;
import com.example.carrental.model.User;
import com.example.carrental.repository.UserRepository;
import com.example.carrental.repository.RentalRepository;
import com.example.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RentalRepository rentalRepository;

    @Override
    public RedirectView register(User user, RedirectAttributes redirectAttributes) {
        try {
            validateUser(user.getNick(), user.getPhoneNumber(), user.getEmail());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return new RedirectView("/login");
        } catch (Exception e) {
            log.error("[{}] Cannot register new user with nick {}", e.getMessage(), user.getNick());
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            redirectAttributes.addFlashAttribute("user", user);
            return new RedirectView("/register");
        }
    }

    @Override
    public String getAccount(String nickname, Model model) {
        final User user = userRepository.findByNick(nickname).orElseThrow();
        model.addAttribute("user", UserMapper.mapToDto(user));
        return "account";
    }

    @Override
    public String editAccount(String nickname, Model model) {
        final User user = userRepository.findByNick(nickname).orElseThrow();
        model.addAttribute("user", UserMapper.mapToDto(user));
        return "editAccount";
    }

    @Override
    public RedirectView saveAccount(String nickname, UserDto userDto, String password, RedirectAttributes redirectAttributes) {
        try {
            User user = userRepository.findByNick(nickname).orElseThrow();
            validateUser(user, userDto);
            user.setNick(userDto.getNick());
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPhoneNumber(userDto.getPhoneNumber());
            if (password != null) {
                user.setPassword(passwordEncoder.encode(password));
            }
            userRepository.save(user);
            redirectAttributes.addFlashAttribute("user", userDto);
            return new RedirectView("/account", true);
        } catch (Exception e) {
            log.error("[{}] Cannot save data for nick {}", e.getMessage(), nickname);
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            redirectAttributes.addFlashAttribute("user", userDto);
            return new RedirectView("/edit-account", true);
        }
    }

    @Override
    @Transactional
    public RedirectView deleteAccount(String nickname) {
        final User user = userRepository.findByNick(nickname).orElseThrow();
        rentalRepository.deleteByUserId(user);
        userRepository.delete(user);
        return new RedirectView("/logout");
    }

    private void validateUser(User user, UserDto userDto) {
        String nick = null;
        String phoneNumber = null;
        String email = null;
        if (user.getNick() != userDto.getNick()) {
            nick = userDto.getNick();
        }
        if (user.getPhoneNumber() != userDto.getPhoneNumber()) {
            phoneNumber = userDto.getPhoneNumber();
        }
        if (user.getEmail() != userDto.getEmail()) {
            email = userDto.getEmail();
        }
        validateUser(nick, phoneNumber, email);
    }

    private void validateUser(String nick, String phoneNumber, String email) {
        if (Objects.nonNull(nick) && userRepository.findByNick(nick).isPresent()) {
            throw new RuntimeException("The nickname already exists");
        }
        if (Objects.nonNull(phoneNumber) && userRepository.findByPhoneNumber(phoneNumber).isPresent()) {
            throw new RuntimeException("The phone number is taken by another user");
        }
        if (Objects.nonNull(email) && userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("The e-mail is taken by another user");
        }
    }
}
