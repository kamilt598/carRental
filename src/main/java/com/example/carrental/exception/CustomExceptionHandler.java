package com.example.carrental.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    public RedirectView handleCustomException(CustomException e, RedirectAttributes redirectAttributes) {
        e.getAttributes().forEach(redirectAttributes::addFlashAttribute);
        return new RedirectView(e.getRedirectUrl(), true);
    }
}
