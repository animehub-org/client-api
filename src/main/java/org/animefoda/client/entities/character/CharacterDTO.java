package org.animefoda.client.entities.character;

import java.io.Serializable;
import java.util.UUID;

public record CharacterDTO(
    UUID id,
    String name,
    String role,
    String description
) implements Serializable {
    public static CharacterDTO fromEntity(Character character) {
        return new CharacterDTO(
            character.getId(),
            character.getName(),
            character.getRole(),
            character.getDescription()
        );
    }
}
