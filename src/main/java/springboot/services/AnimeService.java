package springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.entities.Anime;
import springboot.repositories.AnimeRepository;

@Service
public class AnimeService {

	@Autowired
	private AnimeRepository animeRepository;

	
	public Iterable<Anime> findAll(){
		return animeRepository.findAll();
	}
	
	public Anime findById(Long id) {
		Optional<Anime> anime = animeRepository.findById(id);
		return anime.get();
	}
	
	
	//<S extends T> S save(S entity)
	public <AnimeSave extends Anime> AnimeSave save(AnimeSave anime) {
		return animeRepository.save(anime);
	}
	
	public void deleteById(Long id) {
		animeRepository.deleteById(id);
	}

	public Anime update(Long id, Anime anime) {
		Anime animeUpdate = animeRepository.save(anime);
		return animeRepository.save(animeUpdate);
	}
	
	
	
	
	
}
