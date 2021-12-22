package academy.devdojo.CursoSpringBoot.repository;

import academy.devdojo.CursoSpringBoot.domain.Anime;

import java.util.List;

public interface AnimeRepository {
    List<Anime> listAll();
}
