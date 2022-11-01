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
    @NonNull private Valoration valoration;
    private String description;

    public GameVO(@NonNull String name, @NonNull Integer minPlayers, Integer maxPlayers, @NonNull Valoration valoration, String description) {
        this.name = name;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.valoration = valoration;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
}
