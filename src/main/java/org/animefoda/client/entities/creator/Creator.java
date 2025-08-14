package org.animefoda.client.entities.creator;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "creators", schema = "anime")
@Getter
public class Creator {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String name;

    private String description;

    public CreatorDTO toDTO() {
        return CreatorDTO.fromEntity(this);
    }
}
