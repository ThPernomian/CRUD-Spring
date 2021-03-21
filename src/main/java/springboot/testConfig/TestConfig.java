package springboot.testConfig;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springboot.entities.Anime;
import springboot.repositories.AnimeRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private AnimeRepository animeRep;
	

	
	@Override
	public void run(String... args) throws Exception {
		
		Anime a1 = new Anime(null, "Naruto");
		Anime a2 = new Anime(null, "Bleach");
		Anime a3 = new Anime(null, "Dragon Ball Z");
		Anime a4 = new Anime(null, "Dorohedoro");
		Anime a5 = new Anime(null, "Beastar");
		
		animeRep.saveAll(Arrays.asList(a1, a2, a3, a4, a5));
	}
}
