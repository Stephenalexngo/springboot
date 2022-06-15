package com.stephen.springboot.model;

public class Foo {

    private long userID;
    private String firstName;
    private String lastName;

    public Foo() {
        super();
    }

    public Foo(long userID, String firstName, String lastName) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUserID() {
        return userID;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
