package org.animefoda.client.entities.anime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.animefoda.client.entities.character.Character;
import org.animefoda.client.entities.creator.Creator;
import org.animefoda.client.entities.producer.Producer;
import org.animefoda.client.entities.season.Season;
import org.animefoda.client.entities.state.State;
import org.animefoda.client.entities.studio.Studio;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.OffsetDateTime;
import java.util.*;

@Entity
@Table(name = "anime", schema = "anime")
@Getter
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

//    @Column(name = "averageeptime", nullable = false)
//    private Double averageEptime;

    @Column(name = "date_added", nullable = false)
    private OffsetDateTime dateAdded;

    private String description;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(nullable = false, columnDefinition = "text[]")
    private List<String> genre = new ArrayList<>();

    @NotNull
    @Column(nullable = false)
    private String language;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String name2;

    @NotNull
    @Column(nullable = false)
    private String quality;

    @NotNull
    @Column(nullable = false)
    private boolean visible;

    private String weekday;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "anime_producers",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "producer_id")}
    )
    private Set<Producer> producers;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "anime_creators",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "creator_id")}
    )
    private Set<Creator> creators;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "anime_studios",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "studio_id")}
    )
    private Set<Studio> studios;

    @OneToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "anime_characters",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> characters;

    @OneToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "anime_state",
            schema = "anime",
            joinColumns = {@JoinColumn(name = "anime_id")},
            inverseJoinColumns = {@JoinColumn(name = "state_id")}
    )
    private State state;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "anime_id", insertable = false, updatable = false)
    private Set<Season> seasons = new HashSet<>();


    @Column(name = "releasedate")
    private Date releaseDate;

    public AnimeDTO toDTO() {
        return AnimeDTO.fromEntity(this);
    }

}
