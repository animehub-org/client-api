package org.animefoda.client.entities.season;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.animefoda.client.entities.anime.Anime;
import org.animefoda.client.entities.episode.Episode;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "seasons", schema = "anime")
@Getter
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String name;

//    @NotNull
//    @Column(name = "anime_id", nullable = false)
//    private UUID animeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id", nullable = false)
    private Anime anime;

    @NotNull
    @Column(nullable = false)
    private int index;

    @OneToMany(mappedBy = "season", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private Set<Episode> episodes;

    public SeasonDTO toDTO() {
        return SeasonDTO.fromEntity(this);
    }
}
