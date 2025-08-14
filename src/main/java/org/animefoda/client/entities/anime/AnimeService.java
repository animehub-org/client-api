package org.animefoda.client.entities.anime;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AnimeService {
    private final AnimeRepository repo;

    public AnimeService(AnimeRepository repo) {
        this.repo = repo;
    }

    @Cacheable(value = "animes")
    public List<AnimeDTO> getAll(){
        return repo.findAll().stream().map(AnimeDTO::fromEntity).toList();
    }
}
