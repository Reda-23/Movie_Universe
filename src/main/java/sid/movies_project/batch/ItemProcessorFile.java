package sid.movies_project.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sid.movies_project.model.Genre;
import sid.movies_project.model.Movie;
import sid.movies_project.repository.GenreRepository;
import sid.movies_project.repository.MovieRepository;

import java.util.HashSet;
import java.util.Set;


@Component
public class ItemProcessorFile implements ItemProcessor<Movie,Movie> {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MovieRepository movieRepository;




    @Override
    public Movie process(Movie movie) throws Exception {
        Set<Genre> genreSet = new HashSet<>();
        String[] genreNames = movie.getGenre().split(",");
        Genre genre = new Genre();
        for (String s : genreNames) {
            genreSet.add(new Genre(s, movie));
        }
        movie.setGenreList(genreSet);














        return movie;
    }
}
