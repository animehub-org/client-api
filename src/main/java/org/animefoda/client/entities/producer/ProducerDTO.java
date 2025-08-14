package org.animefoda.client.entities.producer;

import java.io.Serializable;
import java.util.UUID;

public record ProducerDTO(
    UUID id,
    String name,
    String description
) implements Serializable {
    public static ProducerDTO fromEntity(Producer producer) {
        return new ProducerDTO(
            producer.getId(),
            producer.getName(),
            producer.getDescription()
        );
    }
}
