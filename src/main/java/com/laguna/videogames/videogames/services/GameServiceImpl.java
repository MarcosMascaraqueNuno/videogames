package com.laguna.videogames.videogames.services;

import com.laguna.videogames.videogames.models.Game;
import com.laguna.videogames.videogames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        if (game.getId() == null) {
            game.setUuid(UUID.randomUUID());
        } else {
            Game existingGame = findById(game.getId());
            if (existingGame != null) {
                game.setUuid(existingGame.getUuid());
            }
        }

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
            existingGame.setTitle(updatedGame.getTitle());
            existingGame.setDescription(updatedGame.getDescription());
            existingGame.setCategoryId(updatedGame.getCategoryId());

            return gameRepository.save(existingGame);
        }

        return null;
    }

    @Override
    public List<Game> findGamesByTitle(String title) {
        return gameRepository.findGamesByTitleContainsIgnoreCase(title);
    }

    @Override
    public Game patch(Long id, Map<String, Object> updates) {
        Game existingGame = findById(id);

        if (existingGame == null) {
            return null;
        }

        if (updates.containsKey("title") && updates.get("title") != null) {
            existingGame.setTitle((String) updates.get("title"));
        }

        if (updates.containsKey("platform") && updates.get("platform") != null) {
            existingGame.setPlatform((String) updates.get("platform"));
        }

        if (updates.containsKey("launch") && updates.get("launch") != null) {
            existingGame.setLaunch((Date) updates.get("launch"));
        }

        if (updates.containsKey("rating") && updates.get("rating") != null) {
            existingGame.setRating((Integer) updates.get("rating"));
        }

        if (updates.containsKey("description") && updates.get("description") != null) {
            existingGame.setDescription((String) updates.get("description"));
        }

        if (updates.containsKey("price") && updates.get("price") != null) {
            existingGame.setPrice((Double) updates.get("price"));
        }

        if (updates.containsKey("categoryId") && updates.get("categoryId") != null) {
            existingGame.setCategoryId((Long) updates.get("categoryId"));
        }

        return gameRepository.saveAndFlush(existingGame);
    }

}


