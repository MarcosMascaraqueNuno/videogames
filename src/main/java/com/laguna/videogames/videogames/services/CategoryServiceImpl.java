package com.laguna.videogames.videogames.services;

import com.laguna.videogames.videogames.models.Category;
import com.laguna.videogames.videogames.models.Game;
import com.laguna.videogames.videogames.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
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
    public List<Category> findCategoriesByCategoryName(String categoryName) {
        return categoryRepository.findCategoriesByCategoryName(categoryName);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category update(Long id, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);

        if (existingCategory != null) {
            // Actualizar los campos relevantes de la categoría existente con la información de la categoría actualizada
            existingCategory.setCategoryName(updatedCategory.getCategoryName());
            // Actualizar otros campos según sea necesario

            // Guardar la entidad actualizada
            return categoryRepository.save(existingCategory);
        }

        return null; // Devolver nulo si no se encuentra la categoría a actualizar
    }


    @Override
    public Integer countGamesChecked(Long categoryId) {
        // Implementa la lógica para contar los juegos marcados como "checked" en una categoría específica
        // Esto podría requerir el uso de tu repositorio de juegos y la relación con la categoría
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
