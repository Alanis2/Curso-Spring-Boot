package academy.devdojo.CursoSpringBoot.service;

import academy.devdojo.CursoSpringBoot.domain.Anime;
import academy.devdojo.CursoSpringBoot.mapper.AnimeMapper;
import academy.devdojo.CursoSpringBoot.repository.AnimeRepository;
import academy.devdojo.CursoSpringBoot.requests.AnimePostResquestBody;
import academy.devdojo.CursoSpringBoot.requests.AnimePutResquestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> listAll(){
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));
    }

    public Anime save(AnimePostResquestBody animePostResquestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostResquestBody));
    }

    public void delete(long id){
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutResquestBody animePutResquestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutResquestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutResquestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }
}