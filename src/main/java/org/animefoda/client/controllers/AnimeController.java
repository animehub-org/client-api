package org.animefoda.client.controllers;

import entities.anime.AnimeSummaryDTO;
import exception.BadRequestException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import entities.anime.AnimeDTO;
import services.AnimeService;
import org.animefoda.client.pages.FrontEndPages;
import response.ApiResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//public class AnimeSummaryDTOList extends ApiResponse<List<AnimeSummaryDTO>> {}
//public class AnimeDTOList extends ApiResponse<List<AnimeDTO>> {}

@RestController
@RequestMapping("/g/anime")
class AnimeController {

    private final AnimeService animeService;

    AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @Operation(summary = "Busca todos os animes visíveis", description = "Busca todos os animes visíveis por pagina e com a opção de ser summary ou completo")
    @GetMapping("/all")
    ApiResponse<List<?>> getAllAnime(
            @RequestParam(value = "summary", required = false) Boolean summary,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            HttpServletRequest request) {
        if (summary == null) {
            throw new BadRequestException("O parâmetro 'summary' é obrigatório", "MISSING_PARAM");
        }

        if (pageNumber != null && pageNumber < 0) {
            throw new BadRequestException("O parâmetro 'pageNumber' não pode ser negativo", "INVALID_PARAM");
        }
        String[] requestParts = request.getRequestURI().split("/");
        FrontEndPages limitPage = FrontEndPages.fromPath(requestParts[requestParts.length - 1]);

        if (pageNumber == null) {
            pageNumber = 1;
        }
        Pageable page = PageRequest.of(--pageNumber, limitPage.getSizePage());
        if (summary) {
            return new ApiResponse<>(
                    animeService.getAnimeSummaries(page));
        }
        return new ApiResponse<>(
                animeService.getAllDTO(page)
                        .stream().toList());
    }

    @GetMapping("/{id}")
    ApiResponse<AnimeDTO> getAnime(@PathVariable UUID id) {
        return ApiResponse.setSuccess(this.animeService.getById(id), "");
    }
}
