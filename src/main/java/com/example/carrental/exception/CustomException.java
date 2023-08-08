package com.example.carrental.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    private Map<String, ?> attributes;
    private String redirectUrl;
}
