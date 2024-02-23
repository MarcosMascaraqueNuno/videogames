package com.laguna.videogames.videogames.dtos;

import com.laguna.videogames.videogames.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class GameResponseDto {
    private Long Id;
    private UUID uuid;
    private String tittle;
    private String platform;
    private Date launch;
    private Integer rating;
    private String description;
    private Double price;
    private Category category;
}
