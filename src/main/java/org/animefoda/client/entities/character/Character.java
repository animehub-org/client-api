package org.animefoda.client.entities.character;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "characters", schema = "anime")
@Getter
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String name;

    private String role;

    private String description;

    public CharacterDTO toDTO() {
        return CharacterDTO.fromEntity(this);
    }
}
