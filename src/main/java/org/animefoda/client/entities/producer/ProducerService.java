package org.animefoda.client.entities.producer;

import org.animefoda.client.exception.NotFound;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProducerService {
    private final ProducerRepository repo;

    public ProducerService(ProducerRepository repo) {
        this.repo = repo;
    }

    @Cacheable(value = "producer", key="#id")
    public ProducerSummaryDTO getById(UUID id){
        return repo.findById(id)
                .orElseThrow(()-> new NotFound("Producer not found"))
                .toDTO();
    }

    @Cacheable(value = "producers")
    public List<ProducerSummaryDTO> getAll(){
        return repo.findAll().stream().map(Producer::toDTO).toList();
    }
}
