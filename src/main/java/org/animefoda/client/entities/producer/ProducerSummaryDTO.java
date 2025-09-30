package org.animefoda.client.entities.producer;

import java.io.Serializable;
import java.util.UUID;

public record ProducerSummaryDTO(
    UUID id,
    String name,
    String description
) implements Serializable {
    public static ProducerSummaryDTO fromEntity(Producer producer) {
        return new ProducerSummaryDTO(
            producer.getId(),
            producer.getName(),
            producer.getDescription()
        );
    }
}
