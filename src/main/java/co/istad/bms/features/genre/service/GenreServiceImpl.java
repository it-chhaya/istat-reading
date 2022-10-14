package co.istad.bms.features.genre.service;

import java.util.List;

import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Service;

import co.istad.bms.features.genre.model.Genre;
import co.istad.bms.features.genre.repository.GenreRepository;
import co.istad.bms.features.upload.model.Image;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenreServiceImpl implements GenreService {
    
    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {
        // Your logic here...
        return genreRepository.select();
    }

    @Override
    public Genre findById(Integer id) {
        
        Genre genre = genreRepository.selectById(id);

        // Your logic

        return genre;
        
    }

    @Override
    public Genre deleteById(Integer id) {

        Genre genre = genreRepository.selectById(id);

        genreRepository.delete(id);

        return genre;

    }

    @Override
    public Genre addNew(Genre genre) {
        
        Image image = new Image();
        image.setId(1);

        // Set system data
        genre.setIcon(image);
        genre.setIsEnabled(true);

        genreRepository.insert(genre);

        log.info("New Genre = {}", genre);

        return findById(genre.getId());

    }

    @Override
    public Genre updateById(Integer id, Genre genre) {
        genreRepository.update(id, genre);
        return findById(id);
    }

}
