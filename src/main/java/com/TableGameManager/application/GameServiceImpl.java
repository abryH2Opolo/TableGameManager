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
        if(null != gameVo) {
            return new Game(
                gameVo.getId(),
                gameVo.getName(),
                gameVo.getMinPlayers(),
                gameVo.getMaxPlayers(),
                gameVo.getMinAge(),
                gameVo.getDurationInMinutes(),
                gameVo.getValoration(),
                gameVo.getDescription()
            );
        }return null;
    }

    @Override
    public void deleteGame(Integer id) {
        repository.delete(id);
    }

    @Override
    public List<Game> listGames() {
        List<GameVO> games = repository.listAll();
        return new ArrayList<Game>(){{
            for (GameVO game: games) {
                add(
                    new Game(
                        game.getId(),
                        game.getName(),
                        game.getMinPlayers(),
                        game.getMaxPlayers(),
                        game.getMinAge(),
                        game.getDurationInMinutes(),
                        game.getValoration(),
                        game.getDescription()
                    )
                );
            }
        }};
    }

    @Override
    public void updateGame(Game game) {
        repository.update(
            new GameVO(
                game.getId(),
                game.getName(),
                game.getMinPlayers(),
                game.getMaxPlayers(),
                game.getMinAge(),
                game.getDurationInMinutes(),
                game.getValoration(),
                game.getDescription()
            )
        );
    }

    @Override
    public void addGame(Game game) {
        GameVO gameVo = new GameVO(
            game.getName(),
            game.getMinPlayers(),
            game.getMaxPlayers(),
            game.getMinAge(),
            game.getDurationInMinutes(),
            game.getValoration(),
            game.getDescription()
        );
        repository.add(gameVo);
    }
}
