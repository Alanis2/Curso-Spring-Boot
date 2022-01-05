package academy.devdojo.CursoSpringBoot.service;

import academy.devdojo.CursoSpringBoot.domain.Anime;
import academy.devdojo.CursoSpringBoot.repository.AnimeRepository;
import academy.devdojo.CursoSpringBoot.requests.AnimePostResquestBody;
import academy.devdojo.CursoSpringBoot.requests.AnimePutResquestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimePostResquestBody animePostResquestBody) {
        return animeRepository.save(Anime.builder().name(animePostResquestBody.getName()).build());
    }

    public void delete(long id){
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutResquestBody animePutResquestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutResquestBody.getId());
        Anime anime = Anime.builder()
                .id(savedAnime.getId())
                .name(animePutResquestBody.getName())
                .build();

        animeRepository.save(anime);
    }
}