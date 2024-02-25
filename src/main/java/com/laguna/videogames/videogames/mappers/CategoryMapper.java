package com.laguna.videogames.videogames.mappers;

import com.laguna.videogames.videogames.dtos.CategoryRequestDto;
import com.laguna.videogames.videogames.dtos.CategoryResponseDto;
import com.laguna.videogames.videogames.models.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoryMapper {
    public CategoryResponseDto toResponse(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getUuid(),
                category.getCategoryName(),
                category.getMultiplayer(),
                category.getGames()
        );
    }

    public List<CategoryResponseDto> toResponse(List<Category> categories) {
        return categories.stream()
                .map(this::toResponse)
                .toList();
    }

    public Category toModel(CategoryRequestDto categoryRequestDto) {
        return new Category(
                0L,
                UUID.randomUUID(),
                categoryRequestDto.getCategoryName(),
                categoryRequestDto.getMultiplayer(),
                null
        );
    }

    public Category toModelfromRequestDto(Long categoryId) {
        return new Category(
                categoryId,
                null,
                null,
                null,
                null
        );
    }
}
