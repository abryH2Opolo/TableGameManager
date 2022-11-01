package com.TableGameManager.infrastructure.controller;

import com.TableGameManager.application.GameService;
import com.TableGameManager.domain.Game;
import com.TableGameManager.infrastructure.controller.requests.GameRequest;
import com.TableGameManager.infrastructure.controller.responses.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<GameResponse> getGameById(
        @PathVariable(value = "id") Integer id
    ){

        Game game = gameService.getGame(id);
        GameResponse response = new GameResponse(game);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GameResponse> addGame(
        @RequestBody GameRequest request
    ){
        gameService.addGame(
            new Game(
                null,
                request.name,
                request.minPlayers,
                request.maxPlayers,
                request.valoration,
                request.description
            )
        );

        return new ResponseEntity<>( HttpStatus.CREATED);
    }

}
