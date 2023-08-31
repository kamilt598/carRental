package com.example.carrental.service.impl;

import com.example.carrental.config.Endpoints;
import com.example.carrental.dto.UserDto;
import com.example.carrental.mapper.UserMapper;
import com.example.carrental.model.User;
import com.example.carrental.repository.RentalRepository;
import com.example.carrental.repository.UserRepository;
import com.example.carrental.service.UserDataValidator;
import com.example.carrental.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.transaction.Transactional;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RentalRepository rentalRepository;
    private final UserDataValidator userDataValidator;
    private final Endpoints endpoints;

    public RedirectView registerUser(User user) {
        userDataValidator.validateUserData(user.getNick(), user.getPhoneNumber(), user.getEmail(), user, endpoints.getRegister());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new RedirectView(endpoints.getLogin());
    }

    @Override
    public String getAccountByNickname(String nickname, Model model) {
        final User user = userRepository.findByNick(nickname)
                .orElseThrow(userDataValidator.handleIfUserCouldNotBeFound(nickname, endpoints.getHome()));
        model.addAttribute("user", UserMapper.mapToDto(user));
        return "account";
    }

    @Override
    public String getAccounts(Model model) {
        final List<UserDto> userList = userRepository.findAll().stream().map(UserMapper::mapToDto).toList();
        model.addAttribute("userList", userList);
        return "admin/accountManagement";
    }

    @Override
    public String editAccount(String nickname, Model model, Boolean admin) {
        final User user = userRepository.findByNick(nickname)
                .orElseThrow(userDataValidator.handleIfUserCouldNotBeFound(nickname, admin
                        ? endpoints.getAccountManagement()
                        : endpoints.getMyAccount()));
        model.addAttribute("user", UserMapper.mapToDto(user));
        return admin
                ? "admin/editAccountByAdmin"
                : "editAccount";
    }

    @Override
    public RedirectView saveAccount(String nickname, UserDto userDto, String password,
                                    RedirectAttributes redirectAttributes, Boolean admin) {
        final User user = getUserAndValidate(nickname, userDto, admin
                ? endpoints.getEditAccountByAdmin().concat("/").concat(nickname)
                : endpoints.getEditAccount());
        updateAndSaveUserData(user, userDto, password);
        if (admin) {
            return new RedirectView(endpoints.getAccountManagement());
        } else {
            redirectAttributes.addFlashAttribute("user", userDto);
            return new RedirectView(endpoints.getMyAccount(), true);
        }
    }

    @Override
    @Transactional
    public RedirectView deleteAccount(String nickname, Boolean admin) {
        final User user = userRepository.findByNick(nickname)
                .orElseThrow(userDataValidator.handleIfUserCouldNotBeFound(nickname, admin
                        ? endpoints.getAccountManagement()
                        : endpoints.getMyAccount()));
        rentalRepository.deleteByUserId(user);
        userRepository.delete(user);
        return admin
                ? new RedirectView(endpoints.getAccountManagement())
                : new RedirectView(endpoints.getLogout());
    }

    private User getUserAndValidate(String nickname, UserDto userDto, String redirectUrl) {
        final User user = userRepository.findByNick(nickname)
                .orElseThrow(userDataValidator.handleIfUserCouldNotBeFound(nickname, redirectUrl));
        userDataValidator.compareUserDataAndValidate(user, userDto, redirectUrl);
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
