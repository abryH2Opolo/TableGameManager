package com.TableGameManager.application;

import com.TableGameManager.domain.Game;
import com.TableGameManager.domain.GameRepository;
import com.TableGameManager.infrastructure.repository.data.GameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameServiceImpl implements GameService{

    @Autowired
    private GameRepository repository;

    @Override
    public Game getGame(Integer id) {
        GameVO gameVo = repository.get(id);
        return new Game(
            gameVo.getId(),
            gameVo.getDescription(),
            gameVo.getMinPlayers(),
            gameVo.getMaxPlayers(),
            gameVo.getValoration(),
            gameVo.getDescription()
        );
    }

    @Override
    public void deleteGame(Integer id) {

    }

    @Override
    public List<Game> listGames() {
        List<GameVO> games = repository.listAll();
        return new ArrayList<Game>(){{
            for (GameVO g: games) {
                add(
                    new Game(
                        g.getId(),
                        g.getDescription(),
                        g.getMinPlayers(),
                        g.getMaxPlayers(),
                        g.getValoration(),
                        g.getDescription()
                    )
                );
            }
        }};
    }

    @Override
    public void updateGame(Game game) {

    }

    @Override
    public void addGame(Game game) {
        GameVO gameVo = new GameVO(
            game.getName(),
            game.getMinPlayers(),
            game.getMaxPlayers(),
            game.getValoration(),
            game.getDescription()
        );
        repository.add(gameVo);
    }
}
