package com.TableGameManager.infrastructure.controller.responses;

import com.TableGameManager.domain.Game;
import com.TableGameManager.domain.Valoration;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode @ToString
@NoArgsConstructor
@AllArgsConstructor
public class GameResponse {
    public Integer id;
    public String name;
    @JsonProperty("min_players")
    public Integer minPlayers ;
    @JsonProperty("max_players")
    public Integer maxPlayers;
    @JsonProperty("min_age")
    public Integer minAge;
    @JsonProperty("duration_in_minutes")
    public Integer durationInMinutes;
    public Valoration valoration;
    public String description;

    public GameResponse(Game game) {
        this.id = game.getId();
        this.name = game.getName();
        this.minPlayers = game.getMinPlayers();
        this.maxPlayers = game.getMaxPlayers();
        this.minAge = game.getMinAge();
        this.valoration = game.getValoration();
        this.description = game.getDescription();
    }
}
