package org.animefoda.client.entities.episode;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public record EpisodeDTO(
    UUID id,
    UUID animeId,
    UUID seasonId,
    LocalDateTime dateAdded,
    double duration,
    int epIndex,
    String name,
    int openingEnd,
    int openingStart,
    Date releaseDate,
    List<String> resolution,
    boolean visible
) implements Serializable {
    public static EpisodeDTO fromEntity(Episode entity) {
        return new EpisodeDTO(
                entity.getId(),
                entity.getAnime().getId(),
                entity.getSeason().getId(),
                entity.getDateAdded(),
                entity.getDuration(),
                entity.getEpIndex(),
                entity.getName(),
                entity.getOpeningEnd(),
                entity.getOpeningStart(),
                entity.getReleaseDate(),
                entity.getResolution(),
                entity.isVisible()
        );
    }
}
