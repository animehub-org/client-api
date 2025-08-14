package org.animefoda.client.entities.studio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "studios", schema = "anime")
@Getter
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String name;

    private String description;
}
