package org.animefoda.client.entities.anime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {
    @Override
    Page<Anime> findAll(Pageable pageable);

    List<Anime> findAllByVisible(boolean visible);

    Page<Anime> findAllByVisible(boolean visible, Pageable pageable);
}
