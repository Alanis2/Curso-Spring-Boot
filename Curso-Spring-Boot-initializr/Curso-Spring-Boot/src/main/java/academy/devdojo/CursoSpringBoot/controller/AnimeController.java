package academy.devdojo.CursoSpringBoot.controller;

import academy.devdojo.CursoSpringBoot.domain.Anime;
import academy.devdojo.CursoSpringBoot.service.AnimeService;
import academy.devdojo.CursoSpringBoot.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    private final DateUtil dateUtil;
    private final AnimeService animeService;
    @GetMapping
    public List<Anime> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabase(LocalDateTime.now()));

        return animeService.listAll();
    }
}
