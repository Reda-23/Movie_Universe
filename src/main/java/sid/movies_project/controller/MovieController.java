package sid.movies_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sid.movies_project.model.Movie;
import sid.movies_project.services.MovieServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/home")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;


    @GetMapping("/movies")
    List<Movie> movieList(){
        return movieService.allMovies();
    }

    @GetMapping("/movies/{genre}")
    List<Movie> movieByGenre(@PathVariable String genre){
        return movieService.movieByGenre(genre);
    }


}
