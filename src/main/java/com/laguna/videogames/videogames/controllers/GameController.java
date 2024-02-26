package com.laguna.videogames.videogames.controllers;

import com.laguna.videogames.videogames.dtos.GameRequestDto;
import com.laguna.videogames.videogames.dtos.GameResponseDto;
import com.laguna.videogames.videogames.mappers.GameMapper;  // Asegúrate de tener la importación correcta

import com.laguna.videogames.videogames.models.Game;
import com.laguna.videogames.videogames.services.GameService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;
    private final GameMapper gameMapper;

    @Autowired
    public GameController(GameService gameService, GameMapper gameMapper) {
        this.gameService = gameService;
        this.gameMapper = gameMapper;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        List<Game> games = gameService.findAll();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        Game game = gameService.findById(id);
        return game != null ?
                new ResponseEntity<>(game, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Game> createGame(@RequestBody GameRequestDto gameRequestDto) {
        Game newGame = gameService.save(convertDtoToGame(gameRequestDto));
        return new ResponseEntity<>(newGame, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody GameRequestDto gameRequestDto) {
        Game updatedGame = gameService.update(id, convertDtoToGame(gameRequestDto));
        return updatedGame != null ?
                new ResponseEntity<>(updatedGame, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<GameResponseDto> patchGame(
            @PathVariable Long id,
            @RequestBody GameRequestDto gameRequestDto
    ) {
        Map<String, Object> updates = convertDtoToMap(gameRequestDto);
        Game gamePatched = gameService.patch(id, updates);

        return ResponseEntity.ok(gameMapper.toResponse(gamePatched));
    }

    private Map<String, Object> convertDtoToMap(GameRequestDto gameRequestDto) {
        Map<String, Object> map = new HashMap<>();
        map.put("title", gameRequestDto.getTitle());
        map.put("platform", gameRequestDto.getPlatform());
        map.put("launch", gameRequestDto.getLaunch());
        map.put("rating", gameRequestDto.getRating());
        map.put("description", gameRequestDto.getDescription());
        map.put("price", gameRequestDto.getPrice());
        map.put("categoryId", gameRequestDto.getCategoryId());
        return map;
    }


    private Game convertDtoToGame(GameRequestDto gameRequestDto) {
        return new Game(
                null,
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
