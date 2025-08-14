package org.animefoda.client.entities.anime;

import org.animefoda.client.entities.character.CharacterDTO;
import org.animefoda.client.entities.creator.CreatorDTO;
import org.animefoda.client.entities.producer.ProducerDTO;
import org.animefoda.client.entities.season.SeasonDTO;
import org.animefoda.client.entities.state.StateDTO;
import org.animefoda.client.entities.studio.StudioDTO;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record AnimeDTO (
    UUID id,
    double averageEpTime,
    OffsetDateTime dateAdded,
    String description,
    List<String> genre,
    String language,
    String name,
    String name2,
    String quality,
    boolean visible,
    String weekday,
    Set<ProducerDTO> producers,
    Set<CreatorDTO> creators,
    Set<StudioDTO> studios,
    Set<CharacterDTO> characters,
    StateDTO state,
    Date releaseDate,
    Set<SeasonDTO> seasons
) implements Serializable {

    public static AnimeDTO fromEntity(Anime entity) {
        return new AnimeDTO(
                entity.getId(),
                0, // averageEpTime: calculável depois ou pegar de entity.getAverageEptime()
                entity.getDateAdded(),
                entity.getDescription(),
                entity.getGenre(),
                entity.getLanguage(),
                entity.getName(),
                entity.getName2(),
                entity.getQuality(),
                entity.isVisible(),
                entity.getWeekday(),
                entity.getProducers() == null ? Set.of() :
                        entity.getProducers().stream()
                                .map(ProducerDTO::fromEntity)
                                .collect(Collectors.toSet()),
                entity.getCreators() == null ? Set.of() :
                        entity.getCreators().stream()
                                .map(CreatorDTO::fromEntity)
                                .collect(Collectors.toSet()),
                entity.getStudios() == null ? Set.of() :
                        entity.getStudios().stream()
                                .map(StudioDTO::fromEntity)
                                .collect(Collectors.toSet()),
                entity.getCharacters() == null ? Set.of() :
                        entity.getCharacters().stream()
                                .map(CharacterDTO::fromEntity)
                                .collect(Collectors.toSet()),
                entity.getState() != null ? StateDTO.fromEntity(entity.getState()) : null,
                entity.getReleaseDate(),
                entity.getSeasons() == null ? Set.of() :
                        entity.getSeasons().stream()
                                .map(SeasonDTO::fromEntity)
                                .collect(Collectors.toSet())
        );
    }
}
