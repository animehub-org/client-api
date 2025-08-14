package org.animefoda.client.entities.state;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "state", schema = "anime")
@Getter
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StateName name;

    public StateDTO toDTO() {
        return StateDTO.fromEntity(this);
    }
}
