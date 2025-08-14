package org.animefoda.client.entities.producer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "producers", schema = "anime")
@Getter
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String name;

    private String description;

    public ProducerDTO toDTO() {
        return ProducerDTO.fromEntity(this);
    }
}
