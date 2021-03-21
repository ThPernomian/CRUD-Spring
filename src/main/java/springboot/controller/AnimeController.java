package springboot.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import springboot.entities.Anime;
import springboot.services.AnimeService;

@RestController
@RequestMapping(value = "/animes")
public class AnimeController{
	
	@Autowired 
	AnimeService animeService;
	
	@GetMapping
	public ResponseEntity<Iterable<Anime>> findAll(){
		Iterable<Anime> list = animeService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable Long id){
		Anime anime = animeService.findById(id);
		return ResponseEntity.ok().body(anime);
	}
	
	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody Anime anime){
		anime = animeService.save(anime);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(anime.getId()).toUri();
		return ResponseEntity.created(uri).body(anime);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		animeService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Anime> update(@PathVariable Long id, 
			@RequestBody Anime anime){
		anime = animeService.update(id, anime);
		return ResponseEntity.ok().body(anime);
	}
	
}



















