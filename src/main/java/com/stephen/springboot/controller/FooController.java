package com.stephen.springboot.controller;

import com.stephen.springboot.model.Foo;
import com.stephen.springboot.service.impl.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FooController {

    private FooService fooService;

    @Autowired
    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @PostMapping(value = "/foo")
    @ResponseStatus(HttpStatus.CREATED)
    // requestparam and return handlers
    public Foo convertToUpper(@RequestBody Foo foo) {
        return fooService.toUpperCase(foo);
    }

    @GetMapping(value = "/foo")
    public ResponseEntity<Object> displayUpper() {
        Foo foo = new Foo("hello","there");
        return new ResponseEntity<>(fooService.toUpperCase(foo), HttpStatus.OK);
    }

    public static String sample(String test) {
        return test;
    }
}
