package com.TableGameManager.domain;


import com.TableGameManager.infrastructure.repository.data.GameVO;

import java.util.List;

public interface GameRepository {
    GameVO get(Integer id);
    List<GameVO> listAll();
    GameVO delete(Integer id);
    GameVO update(GameVO gameVO);
    void add(GameVO gameVO);
}
