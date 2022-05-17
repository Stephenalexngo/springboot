package com.stephen.springboot.service;

import com.stephen.springboot.model.Foo;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class FooService {

    public Foo toUpperCase(Foo otherFoo) {
        otherFoo.setFirstName(otherFoo.getFirstName().toUpperCase());
        otherFoo.setLastName(otherFoo.getLastName().toUpperCase());
        return otherFoo;
    }
}
