package com.laguna.videogames.videogames.repositories;

import com.laguna.videogames.videogames.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryByUuid(UUID uuid);
}