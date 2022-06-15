package com.stephen.springboot.controller;

import com.stephen.springboot.model.Foo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooControllerTest {

    static Foo foo;

    @BeforeAll
    public static void setup() {
        foo = new Foo(1, "he", "hehe");
    }

    @Test
    public void sampleTest() {
        assertEquals("he", foo.getFirstName());
    }
}
