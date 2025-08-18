package org.animefoda.client.entities.anime;

import jakarta.servlet.http.HttpServletRequest;
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
    Record getAllAnime(
            @RequestParam("summary") Boolean summary,
            @RequestParam("pageNumber") Integer pageNumber,
            HttpServletRequest request
    ) {
        String[] requestParts = request.getRequestURI().split("/");
        FrontEndPages limitPage = FrontEndPages.fromPath(requestParts[requestParts.length - 1]);

        if(pageNumber == null) {
            pageNumber = 0;
        }
        Pageable page = PageRequest.of(pageNumber, limitPage.getSizePage());
        if(summary) {
            return new ApiResponse<>(animeService.getAnimeSummaries(page));
        }
        return new ApiResponse<>(animeService.getAllDTO(page));
    }
}
