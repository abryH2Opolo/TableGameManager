package com.TableGameManager.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Valoration valoration;
    private String description;
}
