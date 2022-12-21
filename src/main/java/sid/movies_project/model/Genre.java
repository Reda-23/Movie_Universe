package sid.movies_project.model;

import javax.persistence.*;


@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movies_id", nullable = false)
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Genre(Long id, String name, Movie movie) {
        this.id = id;
        this.name = name;
        this.movie = movie;
    }
    public Genre(String name, Movie movie) {
        this.name = name;
        this.movie = movie;
    }
    public Genre() {

    }
}
