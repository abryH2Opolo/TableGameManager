package com.TableGameManager.application;

import com.TableGameManager.domain.Game;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameService {

    Game getGame(Integer id);
    void deleteGame(Integer id);
    List<Game> listGames();
    void updateGame(Game game);
    void addGame(Game game);
}
