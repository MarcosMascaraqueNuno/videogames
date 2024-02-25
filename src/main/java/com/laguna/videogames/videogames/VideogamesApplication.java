package com.laguna.videogames.videogames;

import com.laguna.videogames.videogames.services.InitialDataCreationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideogamesApplication {

	@Bean
	public CommandLineRunner init(InitialDataCreationService service) {
		return args -> {
			service.createFakeCategories(4);
			service.createFakeGames(10);
		};
	}
	public static void main(String[] args) {
		System.out.println("Arrancando...");
		SpringApplication.run(VideogamesApplication.class, args);
	}

}
