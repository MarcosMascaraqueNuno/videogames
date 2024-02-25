package com.laguna.videogames.videogames.services;

import com.laguna.videogames.videogames.models.Category;
import com.laguna.videogames.videogames.models.Game;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InitialDataCreationService {

    private final CategoryService categoryService;
    private final GameService gameService;

    private final Faker faker = new Faker(new Locale("en-US"));




    public void createFakeGames(int number) {
        if(number <= 0) return;

        List<Category> allCategories = categoryService.getAllCategories(); // Obtén todas las categorías existentes

        for (int i = 0; i < number; i++) {
            Category randomCategory = getRandomCategory(allCategories);

            Game game = new Game(
                    null,
                    UUID.randomUUID(),
                    faker.videoGame().title(),
                    faker.videoGame().platform(),
                    faker.date().birthday(),
                    faker.number().numberBetween(1, 100),
                    generateRamdomDescription(),
                    faker.number().randomDouble(2, 10, 100),
                    randomCategory.getId() // Usa la ID de la categoría en lugar de null
            );
            gameService.save(game);
        }
    }

    // Método para obtener una categoría aleatoria de la lista de categorías
    private Category getRandomCategory(List<Category> categories) {
        if (categories.isEmpty()) {
            // Manejar el caso en que no hay categorías disponibles
            return null; // o puedes lanzar una excepción, según tus necesidades
        }

        Random random = new Random();
        int randomIndex = random.nextInt(categories.size());
        return categories.get(randomIndex);
    }

    public void createFakeCategories(int number) {
        if(number <= 0) return;
        for (int i = 0; i < number; i++) {
            Category category = new Category(
                    null,
                    UUID.randomUUID(),
                    faker.videoGame().genre(),
                    faker.bool().bool()
            );
            categoryService.save(category);
        }
    }

    public Category createCategory() {

            return new Category(
                    null,
                    UUID.randomUUID(),
                    faker.videoGame().genre(),
                    faker.bool().bool()
            );

    }


    public static String generateRamdomDescription(){
        String [] possibleDescription = {
                "Explora mundos mágicos, resuelve enigmas y derrota monstruos para salvar tu reino.",
                "Enfrenta a rivales en arenas letales, desata habilidades especiales y domina estrategias tácticas.",
                "Sumérgete en la vida cotidiana, toma decisiones cruciales y construye tu propio destino.",
                "Descubre secretos oscuros, desentraña conspiraciones y lucha contra fuerzas paranormales aterradoras.",
                "Diseña ciudades vibrantes, gestiona recursos y da vida a tu visión arquitectónica única."
        };
        int ramdomIndex = (int) (Math.random() * possibleDescription.length);
        return possibleDescription[ramdomIndex];
    }
}
