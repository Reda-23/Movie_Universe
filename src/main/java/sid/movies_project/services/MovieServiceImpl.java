package sid.movies_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sid.movies_project.model.Movie;
import sid.movies_project.repository.MovieRepository;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> movieByGenre(String genre) {
        return movieRepository.getMovieByGenre(genre);
    }
}
