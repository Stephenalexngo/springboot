package com.stephen.springboot.model;

public class Foo {

    private String firstName;
    private String lastName;

    public Foo() {
        super();
    }

    public Foo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
