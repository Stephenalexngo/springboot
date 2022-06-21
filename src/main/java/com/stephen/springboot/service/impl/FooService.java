package com.stephen.springboot.service.impl;

import com.stephen.springboot.dao.impl.FooDao;
import com.stephen.springboot.model.Foo;
import com.stephen.springboot.service.IFooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public List<Foo> getAllUpperCase() {
        return fooDao.getAll();
    }

    @Override
    @Transactional
    public Foo insertUpperCase(Foo otherFoo) {
        Foo convertedFoo = toUpperCase(otherFoo);
        fooDao.save(convertedFoo);

        return convertedFoo;
    }

    @Override
    @Transactional
    public Foo updateUpperCase(Foo otherFoo) {
        return null;
    }

    @Override
    @Transactional
    public Foo deleteUpperCase(Foo otherFoo) {
        return null;
    }

    private Foo toUpperCase(Foo otherFoo) {
        return new Foo(otherFoo.getFirstName().toUpperCase(),
                       otherFoo.getLastName().toUpperCase());
    }
}
