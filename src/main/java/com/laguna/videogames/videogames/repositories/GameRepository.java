package com.laguna.videogames.videogames.repositories;

import com.laguna.videogames.videogames.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, Long> {
    Optional<Game> findGameByUuid(UUID uuid);
    List<Game> findGamesByCategoryId(Long categoryId);
    List<Game> findGamesByToCheck(Boolean toCheck);
}
