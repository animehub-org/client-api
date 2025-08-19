package org.animefoda.client.entities.anime;

import org.animefoda.client.exception.ErrorCode;
import org.animefoda.client.exception.NotFound;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
class AnimeService {
    private final AnimeRepository repo;

    public AnimeService(AnimeRepository repo) {
        this.repo = repo;
    }

    @Cacheable(value = "anime", key = "#id")
    public AnimeDTO getById(UUID id){
        return repo.findById(id)
                .orElseThrow(()->new NotFound("Anime not found"))
                .toDTO();
    }

    // anime DTO
    @Cacheable(value = "animes")
    public List<AnimeDTO> getAllDTO() {
        return repo.findAll().stream().map(Anime::toDTO).toList();
    }
    @Cacheable(value = "animes")
    public Page<AnimeDTO> getAllDTO(Pageable pageable) {
        return repo.findAll(pageable).map(Anime::toDTO);
    }
    @Cacheable(value = "animes")
    public List<AnimeDTO> getAllDTO(boolean visible){
        return repo.findAllByVisible(visible).stream().map(Anime::toDTO).toList();
    }

    //anime SummaryDTO
    @Cacheable(value = "animesSummary")
    public List<AnimeSummaryDTO> getAnimeSummaries(boolean visible) {
        return repo.findAllByVisible(visible).stream().map(Anime::toSummaryDTO).toList();
    }
    @Cacheable(value = "animesSummary")
    public Page<AnimeSummaryDTO> getAnimeSummaries(boolean visible, Pageable pageable) {
        return repo.findAllByVisible(visible, pageable).map(Anime::toSummaryDTO);
    }
    @Cacheable(value = "animesSummary")
    public Page<AnimeSummaryDTO> getAnimeSummaries(Pageable pageable) {
        return repo.findAll(pageable).map(Anime::toSummaryDTO);
    }

    //anime entity
    //preferable not to use this method because it has no cache
    public List<Anime> getAll(){
        return repo.findAll();
    }

}
