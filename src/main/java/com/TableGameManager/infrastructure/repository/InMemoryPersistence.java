package com.TableGameManager.infrastructure.repository;

import com.TableGameManager.domain.GameRepository;
import com.TableGameManager.domain.Valoration;
import com.TableGameManager.infrastructure.repository.data.GameVO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Profile("in_memory")
public class InMemoryPersistence implements GameRepository {

    private HashMap<Integer, GameVO> games = new HashMap<>(){{

        put(1, new GameVO(1,"7 wonders",3, 5,10, 30, Valoration.FIVE, "Eres el líder de una de las siete grandes ciudades de la antigüedad. \n\tDesarrolla tu ciudad promoviendo los descubrimientos científicos, las conquistas militares, los acuerdos comerciales y las construcciones más prestigiosas para guiar a tu civilización a la gloria. Mientras tanto, vigila el progreso de tus competidores, ya que comparten ambiciones similares. ¿Logrará tu maravilla sobrevivir a los avatares del tiempo?"));
        put(2, new GameVO(2,"Taco, Gato, Cabra, Queso, Pizza",3, 8,8, 10, Valoration.FOUR, "En Taco gato cabra queso pizza debes ser el más rápido. Cuando un jugador se descarte de una carta que coincida con la palabra que dice, coloca tu mano sobre el montón central, ¡el último en poner la mano se queda con todas las cartas del montón! Concéntrate y sé el más rápido en deshacerte de todas tus cartas. La diversión está garantizada con este frenético y divertido juego de cartas."));
        put(3, new GameVO(3,"7 wonders duel",2, 2,10, 30, Valoration.FIVE, "7 Wonders Duel: ¡Un juego para dos jugadores que se desarrolla en el universo de 7 Wonders, el juego más premiado del mundo!\n\tDesafía a tu oponente y lleva a tu civilización hacia la victoria mediante edificios prestigiosos, una gran fuerza militar y la supremacía científica. ¡Todo en solo treinta minutos!"));

    }};

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
        games.put(gameVO.getId(), gameVO);
    }
}
