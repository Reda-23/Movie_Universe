package sid.movies_project.model;


import javax.persistence.*;
import java.util.Set;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Genre> genreList;
    @Column(columnDefinition = "TEXT")
    @Lob
    private String releaseDate;
    @Column(columnDefinition = "TEXT")
    @Lob
    private String title;@Column(columnDefinition = "TEXT")
    @Lob
    private String overview;
    @Column(columnDefinition = "TEXT")
    @Lob
    private String popularity;
    @Column(columnDefinition = "TEXT")
    @Lob
    private String vote_count;
    @Column(columnDefinition = "TEXT")
    @Lob
    private String vote_average;
    @Column(columnDefinition = "TEXT")
    @Lob
    private String original_language;
    @Column(columnDefinition = "TEXT")
    @Lob
    private String genre;
    @Column(columnDefinition = "TEXT")
    @Lob
    private String url;

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    public Set<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(Set<Genre> genreList) {
        this.genreList = genreList;
    }

    public Movie(Set<Genre> genreList, String releaseDate, String title, String overview, String popularity, String vote_count, String vote_average, String original_language, String genre, String url) {
        this.genreList = genreList;
        this.releaseDate = releaseDate;
        this.title = title;
        this.overview = overview;
        this.popularity = popularity;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.original_language = original_language;
        this.genre = genre;
        this.url = url;
    }

}
