package com.laguna.videogames.videogames.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
public class GameRequestDto {
    private String title;
    private String platform;
    private Date launch;
    private Integer rating;
    private String description;
    private Double price;
    private Long Category_id;
}
