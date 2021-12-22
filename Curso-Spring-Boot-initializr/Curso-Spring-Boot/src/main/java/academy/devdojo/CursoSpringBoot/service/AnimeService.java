package academy.devdojo.CursoSpringBoot.service;

import academy.devdojo.CursoSpringBoot.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    public List<Anime> listAll(){
        return List.of(new Anime( 1L, "Boku no Hero"), new Anime (2L, "Berserk"));
    }
}
