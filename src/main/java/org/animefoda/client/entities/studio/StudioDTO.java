package org.animefoda.client.entities.studio;

import java.io.Serializable;
import java.util.UUID;

public record StudioDTO(
    UUID id,
    String name,
    String description
) implements Serializable {
    public static StudioDTO fromEntity(Studio studio) {
        return new StudioDTO(
            studio.getId(),
            studio.getName(),
            studio.getDescription()
        );
    }
}
