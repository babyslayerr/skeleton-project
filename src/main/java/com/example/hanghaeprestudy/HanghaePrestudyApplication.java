package com.example.hanghaeprestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HanghaePrestudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HanghaePrestudyApplication.class, args);
	}

}
