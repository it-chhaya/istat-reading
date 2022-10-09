package co.istad.bms.features.genre.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import co.istad.bms.features.genre.model.Genre;
import co.istad.bms.features.genre.service.GenreServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GenreController {

    private final GenreServiceImpl genreServiceImpl;
    
    public GenreController(GenreServiceImpl genreServiceImpl) {
        this.genreServiceImpl = genreServiceImpl;
    }

    @GetMapping("/genre")
    String requestGenreView(Genre genre, ModelMap modelMap) {

        List<Genre> genres = genreServiceImpl.findAll();

        modelMap.addAttribute("genres", genres);
        modelMap.addAttribute("genre", genre);
        return "genre/main";
    }


    @GetMapping("/genre/form")
    String requestGenreFormView(Genre genre, ModelMap modelMap) {
        modelMap.addAttribute("genre", genre);
        return "genre/form";
    }


    @PostMapping("/genre/save")
    String doAddNewGenre(Genre genre) {

        log.info("Genre = {}", genre);

        genreServiceImpl.addNew(genre);

        return "redirect:/genre";
    }


    @PostMapping("/genre/edit/{id}")
    String doEditGenre(@PathVariable Integer id, Genre genre) {
        genreServiceImpl.updateById(id, genre);
        return "redirect:/genre";
    }


    @GetMapping("/genre/edit/{id}")
    String requestEditGenreView(@PathVariable Integer id, ModelMap modelMap) {
        
        log.info("id = {}", id);
        Genre genre = genreServiceImpl.findById(id);

        modelMap.addAttribute("genre", genre);
        modelMap.addAttribute("isEdit", true);

        return "genre/form";

    }

    @GetMapping("/genre/delete/{id}")
    String doDeleteAction(@PathVariable Integer id) {
        genreServiceImpl.deleteById(id);
        return "redirect:/genre";
    }

}
