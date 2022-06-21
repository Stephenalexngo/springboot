package com.stephen.springboot.dao.impl;

import com.stephen.springboot.dao.Dao;
import com.stephen.springboot.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FooDao implements Dao<Foo> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Foo> fooRowMapper = (rs, rowNum) ->
            new Foo(rs.getString("first_name"),
                    rs.getString("last_name"));

    @Autowired
    public FooDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // TODO: fix query, use preparedstatement
    @Override
    public Optional<Foo> get(long id) {
        String query = "SELECT first_name, last_name FROM users WHERE user_id = ?";

        Foo foo = jdbcTemplate.queryForObject(query, fooRowMapper, id);

        return Optional.ofNullable(foo);
    }

    @Override
    public List<Foo> getAll() {
        String query = "SELECT first_name, last_name FROM users";

        return jdbcTemplate.query(query, fooRowMapper);
    }

    // TODO: fix query, use preparedstatement
    @Override
    public void save(Foo foo) {
        String sql = "INSERT INTO users(first_name, last_name) " +
                "VALUES('Testing','User')";

        jdbcTemplate.update(sql);
    }

    @Override
    public void update(Foo foo, String[] params) {

    }

    @Override
    public void delete(Foo foo) {

    }
}
