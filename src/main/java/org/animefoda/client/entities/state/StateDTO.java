package org.animefoda.client.entities.state;

import java.io.Serializable;

public record StateDTO(
    Long id,
    StateName name
) implements Serializable {
    public static StateDTO fromEntity(State state) {
        return new StateDTO(
            state.getId(),
            state.getName()
        );
    }
}
