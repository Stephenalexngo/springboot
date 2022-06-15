package com.stephen.springboot.dao.impl;

import com.stephen.springboot.dao.Dao;
import com.stephen.springboot.model.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class FooDao implements Dao<Foo> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Foo> fooRowMapper = new RowMapper<Foo>() {

        @Override
        public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Foo foo = new Foo(rs.getLong("user_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"));

            return foo;
        }
    };

    @Autowired
    public FooDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // TODO: fix query, use preparedstatement
    @Override
    public Optional<Foo> get(long id) {
        String query = "SELECT * FROM users WHERE user_id = ?";

        Foo foo = jdbcTemplate.queryForObject(query, fooRowMapper, id);

        return Optional.ofNullable(foo);
    }

    @Override
    public List<Foo> getAll() {
        return null;
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
