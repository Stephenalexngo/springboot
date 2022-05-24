package com.stephen.springboot.controller;

import com.stephen.springboot.model.Foo;
import com.stephen.springboot.service.FooService;
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

    @PostMapping(value = "/fooPost")
    public ResponseEntity<Object> convertToUpper(@RequestBody Foo foo) {
        return new ResponseEntity<>(fooService.toUpperCase(foo), HttpStatus.CREATED);
    }

    @GetMapping(value = "/fooGet")
    public ResponseEntity<Object> displayUpper() {
        Foo foo = new Foo("hello","there");
        return new ResponseEntity<>(fooService.toUpperCase(foo), HttpStatus.OK);
    }

    public static String sample(String test) {
        return test;
    }
}
