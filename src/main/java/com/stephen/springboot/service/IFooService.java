package com.stephen.springboot.service;

import com.stephen.springboot.model.Foo;

import java.util.List;

public interface IFooService {

    Foo getUpperCase(Long id);

    List<Foo> getAllUpperCase();

    Foo insertUpperCase(Foo otherFoo);

    Foo updateUpperCase(Foo otherFoo);

    Foo deleteUpperCase(Foo otherFoo);
}
