package org.animefoda.client.entities.season;

import org.animefoda.client.entities.episode.EpisodeDTO;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record SeasonDTO(
    UUID id,
    String name,
    UUID animeId,
    int index,
    Set<EpisodeDTO> episodes
) implements Serializable {
    public static SeasonDTO fromEntity(Season season) {
        Set<EpisodeDTO> episodeDTOs = season.getEpisodes() == null ? Set.of() :
                season.getEpisodes()
                        .stream()
                        .map(EpisodeDTO::fromEntity)
                        .collect(Collectors.toSet());

        return new SeasonDTO(
                season.getId(),
                season.getName(),
                season.getAnime() != null ? season.getAnime().getId() : null,
                season.getIndex(),
                episodeDTOs
        );
    }
}
