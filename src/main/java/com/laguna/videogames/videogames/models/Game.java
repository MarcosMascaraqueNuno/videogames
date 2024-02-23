package com.laguna.videogames.videogames.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String title;
    private String platform;
    private Date launch;
    private Integer rating;
    private String description;
    private Double price;
    private Integer categoryId;
    @ManyToOne
    private Category category;
}
