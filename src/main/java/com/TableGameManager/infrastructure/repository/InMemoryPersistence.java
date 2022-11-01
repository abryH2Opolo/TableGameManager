package com.TableGameManager.infrastructure.repository;

import com.TableGameManager.domain.GameRepository;
import com.TableGameManager.infrastructure.repository.data.GameVO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryPersistence implements GameRepository {

    private HashMap<Integer, GameVO> games = new HashMap<>();

    @Override
    public GameVO get(Integer id) {
        return games.get(id);
    }

    @Override
    public List<GameVO> listAll() {
        System.out.println("return: " + games.values());
        return new ArrayList<>(games.values());
    }

    @Override
    public GameVO delete(Integer id) {
        return games.remove(id);
    }

    @Override
    public GameVO update(GameVO gameVO)  {
        return games.replace(gameVO.getId(), gameVO);
    }

    @Override
    public void add(GameVO gameVO) {
        System.out.println("added game: " + gameVO);
        gameVO.setId(games.size() + 1);
        games.put(gameVO.getId(), gameVO);
    }
}
