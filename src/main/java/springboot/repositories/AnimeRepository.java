package springboot.repositories;

import org.springframework.data.repository.CrudRepository;

import springboot.entities.Anime;

public interface AnimeRepository extends CrudRepository<Anime, Long>{

	
}
