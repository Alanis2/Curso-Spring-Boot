package academy.devdojo.CursoSpringBoot.mapper;

import academy.devdojo.CursoSpringBoot.domain.Anime;
import academy.devdojo.CursoSpringBoot.requests.AnimePostResquestBody;
import academy.devdojo.CursoSpringBoot.requests.AnimePutResquestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime toAnime(AnimePostResquestBody animePostResquestBody);

    public abstract Anime toAnime(AnimePutResquestBody animePutResquestBody);
}
