package com.stephen.springboot.service.impl;

import com.stephen.springboot.model.Foo;
import com.stephen.springboot.service.IFooService;
import org.springframework.stereotype.Service;

@Service
public class FooService implements IFooService {

    public Foo toUpperCase(Foo otherFoo) {
        return new Foo(otherFoo.getFirstName().toUpperCase(), otherFoo.getLastName().toUpperCase());
    }
}
