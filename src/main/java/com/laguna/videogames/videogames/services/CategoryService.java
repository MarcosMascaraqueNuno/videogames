package com.laguna.videogames.videogames.services;

import com.laguna.videogames.videogames.models.Category;
import com.laguna.videogames.videogames.models.Game;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category findByUuid(UUID uuid);

    Category save(Category category);

    List<Category> findCategoriesByCategoryName(String category_name);

    void deleteById(Long id);

    Category update(Long id, Category model);


    Integer countGamesChecked(Long categoryId);
}
