package org.animefoda.client.configuration;

import entities.anime.AnimeRepository;
import entities.genre.GenreRepository;
import entities.producer.ProducerRepository;
import entities.state.StateRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.AnimeService;
import services.GenreService;
import services.ProducerService;
import services.StateService;

@Configuration
class BeanConfiguration {
    @Bean
    public AnimeService animeService(AnimeRepository animeRepository) {
        return new AnimeService(animeRepository);
    }
    @Bean
    public ProducerService producerService(ProducerRepository producerRepository) {
        return new ProducerService(producerRepository);
    }
    @Bean
    public GenreService genreService(GenreRepository genreRepository) {
        return new GenreService(genreRepository);
    }
    @Bean
    public StateService stateService(StateRepository stateRepository) {
        return new StateService(stateRepository);
    }
}
