package org.animefoda.client.entities.anime;

import jakarta.servlet.http.HttpServletRequest;
import org.animefoda.client.exception.BadRequestException;
import org.animefoda.client.pages.FrontEndPages;
import org.animefoda.client.response.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/g/anime")
class AnimeController {

    private final AnimeService animeService;

    AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }


    @GetMapping("/all")
    ApiResponse<List<?>> getAllAnime(
            @RequestParam(value = "summary", required = false) Boolean summary,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            HttpServletRequest request
    ) {
        if (summary == null) {
            throw new BadRequestException("O parâmetro 'summary' é obrigatório", "MISSING_PARAM");
        }

        if (pageNumber != null && pageNumber < 0) {
            throw new BadRequestException("O parâmetro 'pageNumber' não pode ser negativo", "INVALID_PARAM");
        }
        String[] requestParts = request.getRequestURI().split("/");
        FrontEndPages limitPage = FrontEndPages.fromPath(requestParts[requestParts.length - 1]);

        if(pageNumber == null) {
            pageNumber = 0;
        }
        Pageable page = PageRequest.of(pageNumber, limitPage.getSizePage());
        if(summary) {
            return new ApiResponse<>(
                    animeService.getAnimeSummaries(page)
                            .stream()
                            .toList()
            );
        }
        return new ApiResponse<>(
                animeService.getAllDTO(page)
                        .stream().toList()
        );
    }
}
