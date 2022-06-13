package com.stephen.springboot.controller;

import com.stephen.springboot.model.Foo;
import com.stephen.springboot.service.impl.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    private FooService fooService;

    @Autowired
    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    // TODO: Study requestparam and return handlers
    @PostMapping(value = "/foo")
    @ResponseStatus(HttpStatus.CREATED)
    // TODO: Make it List<Foo>
    public Foo convertToUpper(@RequestBody Foo foo) {
        return fooService.toUpperCase(foo);
    }

    @GetMapping(value = "/foo")
    public Foo displayUpper() {
        return fooService.toUpperCase(new Foo("hello","there"));
    }

    public static String sample(String test) {
        return test;
    }
}
