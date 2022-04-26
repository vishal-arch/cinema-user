package com.in.cinema.user;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaUserApplication {

	public static void main(String[] args) {

		System.out.println("Starting");
		SpringApplication.run(CinemaUserApplication.class, args);
	}

}
