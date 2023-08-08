package com.example.carrental.service;

import com.example.carrental.dto.UserDto;
import com.example.carrental.exception.CustomException;
import com.example.carrental.model.User;
import com.example.carrental.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class UserDataValidator {

    private static final String NICK_VALIDATION_ERROR = "The nickname %s already exists";
    private static final String PHONE_NUMBER_VALIDATION_ERROR = "The phone number %s is taken by another user";
    private static final String EMAIL_VALIDATION_ERROR = "The e-mail %s is taken by another user";
    private final UserRepository userRepository;

    public void compareUserDataAndValidate(User user, UserDto userDto, String redirectUrl) {
        final String nick = Objects.equals(user.getNick(), userDto.getNick()) ? null : userDto.getNick();
        final String phoneNumber = Objects.equals(user.getPhoneNumber(), userDto.getPhoneNumber()) ? null : userDto.getPhoneNumber();
        final String email = Objects.equals(user.getEmail(), userDto.getEmail()) ? null : userDto.getEmail();
        validateUserData(nick, phoneNumber, email, userDto, redirectUrl);
    }

    public void validateUserData(String nick, String phoneNumber, String email, Object user, String redirectUrl) {
        if (Objects.nonNull(nick) && userRepository.findByNick(nick).isPresent()) {
            throwValidationException(String.format(NICK_VALIDATION_ERROR, nick), user, redirectUrl);
        }
        if (Objects.nonNull(phoneNumber) && userRepository.findByPhoneNumber(phoneNumber).isPresent()) {
            throwValidationException(String.format(PHONE_NUMBER_VALIDATION_ERROR, phoneNumber), user, redirectUrl);
        }
        if (Objects.nonNull(email) && userRepository.findByEmail(email).isPresent()) {
            throwValidationException(String.format(EMAIL_VALIDATION_ERROR, email), user, redirectUrl);
        }
    }

    public Supplier<CustomException> handleIfUserCouldNotBeFound(String nickname, String redirectUrl) {
        return () -> new CustomException(Map.of("error", String.format("Cannot find user %s", nickname)), redirectUrl);
    }

    private void throwValidationException(String errorMessage, Object user, String redirectUrl) {
        throw new CustomException(Map.of("error", errorMessage, "user", user), redirectUrl);
    }
}
