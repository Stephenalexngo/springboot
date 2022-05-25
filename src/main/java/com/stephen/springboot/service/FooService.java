package com.stephen.springboot.service;

import com.stephen.springboot.model.Foo;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class FooService {

    public Foo toUpperCase(Foo otherFoo) {
        return new Foo(otherFoo.getFirstName().toUpperCase(), otherFoo.getLastName().toUpperCase());
    }
}
