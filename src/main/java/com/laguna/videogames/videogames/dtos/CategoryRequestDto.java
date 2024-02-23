package com.laguna.videogames.videogames.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class CategoryRequestDto {
    private String category_name;
    private Boolean multiplayer;
}
