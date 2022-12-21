package sid.movies_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sid.movies_project.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    
    boolean existsGenreByName(String name);
}
