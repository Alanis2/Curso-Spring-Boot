package academy.devdojo.CursoSpringBoot.repository;

import academy.devdojo.CursoSpringBoot.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
