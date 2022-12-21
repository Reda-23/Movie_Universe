package sid.movies_project.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sid.movies_project.model.Genre;
import sid.movies_project.model.Movie;
import sid.movies_project.repository.GenreRepository;
import sid.movies_project.repository.MovieRepository;

import java.util.List;

@Component
public class ItemWriterFile implements ItemWriter<Movie> {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void write(List<? extends Movie> list) throws Exception {
        for (Movie m:list){
            Movie mé = movieRepository.save(m);
/*            for(Genre g:mé.getGenreList()){
                boolean exist = genreRepository.existsGenreByName(g.getName());
                System.out.println(exist);
                if(exist == false){
                    genreRepository.save(g);
                }*/

            }

        }
    }

