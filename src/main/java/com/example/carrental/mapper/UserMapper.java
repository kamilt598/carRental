package com.example.carrental.mapper;

import com.example.carrental.dto.UserDto;
import com.example.carrental.model.User;

public class UserMapper {

    public static UserDto mapToDto(User user) {
        return UserDto.builder()
                .nick(user.getNick())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
