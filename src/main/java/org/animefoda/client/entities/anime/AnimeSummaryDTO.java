package org.animefoda.client.entities.anime;

import java.util.List;
import java.util.UUID;

public record AnimeSummaryDTO(
    UUID id,
//    double averageEpTime,
    String description,
    List<String> genre,
    String name,
    String name2,
    String quality,
    String language
) {
    public static AnimeSummaryDTO fromEntity(Anime anime) {
        return new AnimeSummaryDTO(
            anime.getId(),
            anime.getDescription(),
            anime.getGenre(),
            anime.getName(),
            anime.getName2(),
            anime.getQuality(),
            anime.getLanguage()
        );
    }
}
