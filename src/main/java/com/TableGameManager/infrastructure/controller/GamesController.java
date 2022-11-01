package com.TableGameManager.infrastructure.controller;

import com.TableGameManager.application.GameService;
import com.TableGameManager.domain.Game;
import com.TableGameManager.infrastructure.controller.requests.GameRequest;
import com.TableGameManager.infrastructure.controller.responses.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("games")
public class GamesController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<Game>> listAllGames(
    ){
        List<Game> games = gameService.listGames();
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

}
