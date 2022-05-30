package com.stephen.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringbootApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO users(first_name, last_name) " +
				"VALUES('Testing','User')";

		int row = jdbcTemplate.update(sql);

		if(row > 0) {
			System.out.println("INSERTED");
		}
	}
}
