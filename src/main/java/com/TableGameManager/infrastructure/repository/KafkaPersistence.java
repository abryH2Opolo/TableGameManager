package com.TableGameManager.infrastructure.repository;

import com.TableGameManager.domain.GameRepository;
import com.TableGameManager.infrastructure.repository.data.GameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Profile("kafka")
public class KafkaPersistence implements GameRepository {

    private HashMap<Integer, GameVO> games = new HashMap<>();
    @Autowired private KafkaTemplate<String, GameVO> template;


    @KafkaListener(topics = "games", groupId = "myGroup")
    public void consumeGames(GameVO gameVO){
        gameVO.setId(games.size() + 1);
        games.put(gameVO.getId(), gameVO);
    }

    @Override
    public GameVO get(Integer id) {
        return games.get(id);
    }

    @Override
    public List<GameVO> listAll() {
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
        gameVO.setId(games.size() + 1);
        template.send("games", gameVO);
    }
}
