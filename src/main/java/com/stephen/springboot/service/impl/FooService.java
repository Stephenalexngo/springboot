package com.stephen.springboot.service.impl;

import com.stephen.springboot.dao.impl.FooDao;
import com.stephen.springboot.model.Foo;
import com.stephen.springboot.service.IFooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class FooService implements IFooService {

    private final FooDao fooDao;

    @Autowired
    public FooService(FooDao fooDao) {
        this.fooDao = fooDao;
    }

    // TODO: check if null, isPresent()
    @Override
    public Foo getUpperCase(Long id) {
        Optional<Foo> foo = fooDao.get(id);

        return toUpperCase(foo.get());
    }

    @Override
    @Transactional
    public Foo insertUpperCase(Foo otherFoo) {
        Foo convertedFoo = toUpperCase(otherFoo);
        fooDao.save(convertedFoo);

        return convertedFoo;
    }

    private Foo toUpperCase(Foo otherFoo) {
        return new Foo(otherFoo.getUserID(),
                       otherFoo.getFirstName().toUpperCase(),
                       otherFoo.getLastName().toUpperCase());
    }
}
