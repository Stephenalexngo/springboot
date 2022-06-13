package com.stephen.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO users(first_name, last_name) " +
//				"VALUES('Testing','User')";
//
//		int row = jdbcTemplate.update(sql);
//
//		if(row > 0) {
//			System.out.println("INSERTED");
//		}
//	}
}
