package com.laguna.videogames.videogames.services;

import com.laguna.videogames.videogames.models.Game;

import java.util.List;
import java.util.UUID;

public interface GameService {
    List<Game> findAll();

    Game findById(Long id);

    Game findByUuid(UUID uuid);

    Game save(Game game);

    void deleteById(Long id);

    Game update(Long id, Game model);
    List<Game> findGamesByTitle(String Title);



}
