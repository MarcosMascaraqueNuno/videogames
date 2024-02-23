package com.laguna.videogames.videogames.dtos;

import com.laguna.videogames.videogames.models.Category;
import com.laguna.videogames.videogames.models.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CategoryResponseDto {
    private Long id;
    private UUID uuid;
    private String categoryName;
    private Boolean multiplayer;
    private List<Game> game;
}

