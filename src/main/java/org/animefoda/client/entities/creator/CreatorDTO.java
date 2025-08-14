package org.animefoda.client.entities.creator;

import java.io.Serializable;
import java.util.UUID;

public record CreatorDTO(
    UUID id,
    String name,
    String description
) implements Serializable {
    public static CreatorDTO fromEntity(Creator creator) {
        return new CreatorDTO(
            creator.getId(),
            creator.getName(),
            creator.getDescription()
        );
    }
}
