package com.TableGameManager.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor @Getter @EqualsAndHashCode @ToString
public class Game {

    private Integer id;
    private String name;
    private Integer minPlayers ;
    private Integer maxPlayers;
    private Integer minAge;
    private Integer durationInMinutes;;
    private Valoration valoration;
    private String description;
}
