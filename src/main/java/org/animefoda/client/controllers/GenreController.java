package org.animefoda.client.controllers;

import entities.genre.Genre;
import entities.genre.GenreDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.ApiResponse;
import services.GenreService;

import java.util.List;

@RestController
@RequestMapping("/genre")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService= genreService;
    }

    @GetMapping("/all")
    public ApiResponse<List<GenreDTO>> allGenres() {
        return ApiResponse.setSuccess(genreService.getAll().stream().map(Genre::toDTO).toList());
    }
}
