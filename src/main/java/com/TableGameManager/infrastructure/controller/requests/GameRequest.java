package com.TableGameManager.infrastructure.controller.requests;

import com.TableGameManager.domain.Valoration;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode @ToString
@NoArgsConstructor
@AllArgsConstructor
public class GameRequest {
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

}
