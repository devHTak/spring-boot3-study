package com.example;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class SpringR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringR2dbcApplication.class, args);
	}

}
