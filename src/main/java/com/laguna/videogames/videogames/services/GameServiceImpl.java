package com.laguna.videogames.videogames.services;

import com.laguna.videogames.videogames.models.Game;
import com.laguna.videogames.videogames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).orElse(null);
    }

    @Override
    public Game findByUuid(UUID uuid) {
        return gameRepository.findGameByUuid(uuid).orElse(null);
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteById(Long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public Game update(Long id, Game updatedGame) {
        Game existingGame = gameRepository.findById(id).orElse(null);

        if (existingGame != null) {
            // Actualizar los campos relevantes del juego existente con la información del juego actualizado
            existingGame.setTitle(updatedGame.getTitle());
            existingGame.setDescription(updatedGame.getDescription());
            existingGame.setCategory(updatedGame.getCategory());
            // Actualiza otros campos según sea necesario

            // Guardar la entidad actualizada
            return gameRepository.save(existingGame);
        }

        return null; // Devolver nulo si no se encuentra el juego a actualizar
    }

    @Override
    public List<Game> findGamesByTitle(String title) {
        return gameRepository.findGamesByTitleContainsIgnoreCase(title);
    }

}
