package org.animefoda.client.entities.producer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.animefoda.client.entities.anime.Anime;

import java.util.List;
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="anime_producers",
        schema="anime",
        joinColumns = {@JoinColumn(name = "producer_id")},
        inverseJoinColumns = {@JoinColumn(name = "anime_id")}
    )
    private List<Anime> animes;

    public ProducerSummaryDTO toDTO() {
        return ProducerSummaryDTO.fromEntity(this);
    }
}
