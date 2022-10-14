package co.istad.bms.features.genre.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import co.istad.bms.features.genre.service.GenreServiceImpl;

@Controller
public class GenreTmplController {

    private final GenreServiceImpl genreServiceImpl;


    public GenreTmplController(GenreServiceImpl genreServiceImpl) {
        this.genreServiceImpl = genreServiceImpl;
    }


    @GetMapping("/tmpl/genre/table")
    String requestGenreTableTmpl(ModelMap modelMap) {
        modelMap.addAttribute("genres", genreServiceImpl.findAll());
        return "/genre/table";
    }

}
