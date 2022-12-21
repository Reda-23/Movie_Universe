package sid.movies_project.services;

import sid.movies_project.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> allMovies();
    List<Movie> movieByGenre(String genre);


}
