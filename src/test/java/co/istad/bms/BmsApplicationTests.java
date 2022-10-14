package co.istad.bms;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.istad.bms.features.genre.model.Genre;
import co.istad.bms.features.genre.repository.GenreRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BmsApplicationTests {

	@Autowired
	GenreRepository genreRepository;

	@Test
	void selectGenres() {
		List<Genre> genres = genreRepository.select();
		genres.forEach((genre)->log.info("Genres ={}", genre));
	}

	@Test
	void updateGenreById() {
		Genre genre = new Genre();
		genre.setTitle("Update title");
		genre.setDescription("Update desc");

		genreRepository.update(12, genre);
	}

}
