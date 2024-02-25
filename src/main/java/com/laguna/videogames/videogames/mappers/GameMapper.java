package com.laguna.videogames.videogames.mappers;

import com.laguna.videogames.videogames.dtos.GameRequestDto;
import com.laguna.videogames.videogames.dtos.GameResponseDto;
import com.laguna.videogames.videogames.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GameMapper {
    private final CategoryMapper categoryMapper;

    @Autowired
    public GameMapper (CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public GameResponseDto toResponse(Game game) {
        return new GameResponseDto(
                game.getId(),
                game.getUuid(),
                game.getTitle(),
                game.getPlatform(),
                game.getLaunch(),
                game.getRating(),
                game.getDescription(),
                game.getPrice(),
                game.getCategoryId()
        );
    }

    public List<GameResponseDto> toResponse(List<Game> game) {
        return game.stream()
                .map(this::toResponse)
                .toList();
    }

    public Game toModel(GameRequestDto gameRequestDto) {
        return new Game(
                0L,
                UUID.randomUUID(),
                gameRequestDto.getTitle(),
                gameRequestDto.getPlatform(),
                gameRequestDto.getLaunch(),
                gameRequestDto.getRating(),
                gameRequestDto.getDescription(),
                gameRequestDto.getPrice(),
                gameRequestDto.getCategoryId()
        );
    }
}
