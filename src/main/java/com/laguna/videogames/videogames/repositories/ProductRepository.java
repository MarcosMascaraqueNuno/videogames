package com.laguna.videogames.videogames.repositories;
import com.laguna.videogames.videogames.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Game, Long> {
    Optional<Game> findProductByUuid(UUID uuid);
    List<Game> findProductsByCategoryId(Long categoryId);

}
