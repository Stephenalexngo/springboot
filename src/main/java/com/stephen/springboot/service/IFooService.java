package com.stephen.springboot.service;

import com.stephen.springboot.model.Foo;

public interface IFooService {

    Foo getUpperCase(Long id);

    Foo insertUpperCase(Foo otherFoo);
}
