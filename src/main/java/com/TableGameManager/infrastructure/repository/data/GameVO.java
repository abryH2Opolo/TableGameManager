package com.TableGameManager.infrastructure.repository.data;

import com.TableGameManager.domain.Valoration;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class GameVO {

    private int id;
    @NonNull private String name;
    @NonNull private Integer minPlayers;
    private Integer maxPlayers;
    @NonNull private Integer minAge;
    @NonNull private Integer durationInMinutes;
    @NonNull private Valoration valoration;
    private String description;

    public GameVO(
        @NonNull String name,
        @NonNull Integer minPlayers,
        Integer maxPlayers,
        @NonNull Integer minAge,
        @NonNull Integer durationInMinutes,
        @NonNull Valoration valoration,
        String description
    ) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.minAge = minAge;
        this.valoration = valoration;
        this.durationInMinutes = durationInMinutes;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
