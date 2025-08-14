package org.animefoda.client.entities.episode;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.animefoda.client.entities.anime.Anime;
import org.animefoda.client.entities.season.Season;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "episodes", schema = "anime")
@Getter
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id", insertable = false, updatable = false)
    private Anime anime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id", insertable = false, updatable = false)
    private Season season;

    @NotNull
    @Column(name = "date_added", nullable = false)
    private LocalDateTime dateAdded;

    @NotNull
    @Column(nullable = false)
    private double duration;

    @NotNull
    @Column(name = "epindex", nullable = false)
    private int epIndex;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Column(name = "openingend")
    private int openingEnd;

    @Column(name = "openingstart")
    private int openingStart;

    @Column(name = "releasedate")
    private Date releaseDate;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @NotNull
    @Column(nullable = false)
    private List<String> resolution;

    @NotNull
    @Column(nullable = false)
    private boolean visible;

    public EpisodeDTO toDTO() {
        return EpisodeDTO.fromEntity(this);
    }
}
