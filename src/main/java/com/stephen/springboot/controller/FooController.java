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

    @RequestMapping(value = "/foo", method = RequestMethod.POST)
    public ResponseEntity<Object> convertToUpper(@RequestBody Foo foo) {
        return new ResponseEntity<>(fooService.toUpperCase(foo.getFirstName(), foo.getLastName()), HttpStatus.OK);
    }

    @RequestMapping(value = "/foo")
    public ResponseEntity<Object> displayUpper() {
        return new ResponseEntity<>(fooService.toUpperCase("hello", "There"), HttpStatus.OK);
    }
}
