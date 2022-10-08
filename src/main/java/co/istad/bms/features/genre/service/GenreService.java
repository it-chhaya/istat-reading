package co.istad.bms.features.genre.service;

import java.util.List;

import co.istad.bms.features.genre.model.Genre;

public interface GenreService {
    

    /**
     * Find all genres from database
     * @return List<Genre>
     */
    List<Genre> findAll();



    /**
     * Find genre by id from database
     * @param id is the identifier of genre
     * @return Genre
     */
    Genre findById(Integer id);


    
    Genre deleteById(Integer id);

    Genre addNew(Genre genre);

    Genre updateById(Integer id, Genre genre);

}
