package com.laguna.videogames.videogames.controllers;

import com.laguna.videogames.videogames.dtos.GameRequestDto;
import com.laguna.videogames.videogames.models.Game;
import com.laguna.videogames.videogames.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
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

    private Game convertDtoToGame(GameRequestDto gameRequestDto) {
        return new Game(
                null,  // id: Será generado automáticamente por la base de datos
                UUID.randomUUID(),  // uuid: Generamos uno nuevo
                gameRequestDto.getTitle(),
                gameRequestDto.getPlatform(),
                gameRequestDto.getLaunch(),
                gameRequestDto.getRating(),
                gameRequestDto.getDescription(),
                gameRequestDto.getPrice(),
                gameRequestDto.getCategoryId()  // category: Puede necesitar ajustes según cómo manejes las categorías
        );
    }
}
