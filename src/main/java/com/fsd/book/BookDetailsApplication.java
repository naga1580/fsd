package com.fsd.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.fsd.book.repository")
public class BookDetailsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BookDetailsApplication.class, args);
	}
}
