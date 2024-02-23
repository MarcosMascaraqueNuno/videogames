package com.laguna.videogames.videogames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VideogamesApplication {

	public static void main(String[] args) {
		System.out.println("Arrancando...");
		SpringApplication.run(VideogamesApplication.class, args);
	}

}
