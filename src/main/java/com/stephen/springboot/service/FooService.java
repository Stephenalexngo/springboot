package com.stephen.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class FooService {

    public String toUpperCase(String firstName, String lastName) {
        return firstName.toUpperCase() + " " + lastName.toUpperCase();
    }
}
