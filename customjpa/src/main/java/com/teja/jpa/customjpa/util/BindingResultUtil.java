package com.teja.jpa.customjpa.util;

import com.teja.jpa.customjpa.exception.StudentNotFound;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class BindingResultUtil {

    public static List<String> constructErrors(BindingResult bindingResult) {
        List<String> list = new ArrayList<>();
        bindingResult.getAllErrors().forEach(e -> {
            if (e instanceof FieldError) {
                FieldError fieldError = (FieldError) e;
                list.add(String.format("%s %s", fieldError.getField(), fieldError.getDefaultMessage()));
            } else {
                list.add(e.getDefaultMessage());
            }
        });
        return list;
    }
}
