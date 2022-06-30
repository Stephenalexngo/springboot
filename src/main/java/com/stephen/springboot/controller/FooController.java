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

import java.util.List;

// TODO: add custom exception handler
@RestController
public class FooController {

    private final FooService fooService;

    @Autowired
    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    // TODO: add path variable for this
    @GetMapping(value = "/foo")
    public Foo displayUpper() {
        return fooService.getUpperCase(1L);
    }

    @GetMapping(value = "/fooAll")
    public List<Foo> displayAllUpper() {
        return fooService.getAllUpperCase();
    }

    // TODO: Study requestparam and return handlers
    @PostMapping(value = "/foo")
    @ResponseStatus(HttpStatus.CREATED)
    // TODO: Make it List<Foo>
    public Foo insertUpper(@RequestBody Foo foo) {
        return fooService.insertUpperCase(foo);
    }

    public static String sample(String test) {
        return test;
    }
}
