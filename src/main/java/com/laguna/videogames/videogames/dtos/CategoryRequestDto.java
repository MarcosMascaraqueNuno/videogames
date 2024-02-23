package com.laguna.videogames.videogames.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class CategoryRequestDto {
    private String categoryName;
    private Boolean multiplayer;
}
