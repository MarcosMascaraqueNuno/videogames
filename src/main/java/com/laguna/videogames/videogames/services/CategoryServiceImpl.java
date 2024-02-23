package com.laguna.videogames.videogames.services;

import com.laguna.videogames.videogames.models.Category;
import com.laguna.videogames.videogames.models.Game;
import com.laguna.videogames.videogames.repositories.CategoryRepository;
import com.laguna.videogames.videogames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final GameRepository gameRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, GameRepository gameRepository) {
        this.categoryRepository = categoryRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Game> getGamesByCategoryId(Long id) {
        Category category = this.findById(id);

        if (category != null) {
            return gameRepository.findGamesByCategoryId(id);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public Integer countGamesChecked(Long categoryId) {
        List<Game> checkedGamesList = new ArrayList<>();

        List<Game> gamesChecked = gameRepository.findGamesByToCheck(true);

        for (Game game : gamesChecked) {
            if (categoryId.equals(game.getCategoryId())) {
                checkedGamesList.add(game);
            }
        }

        return checkedGamesList.size();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category findByUuid(UUID uuid) {
        return categoryRepository.findCategoryByUuid(uuid).orElse(null);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoriesByCategoryName(String category_name) {
        return categoryRepository.findCategoriesByCategoryName(category_name);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(Long id, Category model) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setCategoryName(model.getCategoryName());
            existingCategory.setMultiplayer(model.getMultiplayer());
            // Puedes actualizar otros campos si es necesario

            return categoryRepository.save(existingCategory);
        }
        return null;
    }
}
