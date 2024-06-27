package org.valentic.hodak.cinestar.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movie")
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "directedBy")
    private String directedBy;
    @Column(name = "releaseYear")
    private Integer releaseYear;
    @Column(name = "runtime")
    private Integer runtime;
    @ElementCollection
    private List<String> genres;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Screening> screenings;

    public long getId() {
        return id;
    }
    public void setId(long movieId) {
        this.id = movieId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirectedBy() {
        return directedBy;
    }
    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRuntime() {
        return runtime;
    }
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }
    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getTitle(), movie.getTitle()) && Objects.equals(getDirectedBy(), movie.getDirectedBy()) && Objects.equals(getReleaseYear(), movie.getReleaseYear()) && Objects.equals(getRuntime(), movie.getRuntime()) && Objects.equals(getGenres(), movie.getGenres()) && Objects.equals(getScreenings(), movie.getScreenings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDirectedBy(), getReleaseYear(), getRuntime(), getGenres(), getScreenings());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", directedBy='" + directedBy + '\'' +
                ", releaseYear=" + releaseYear +
                ", runtime=" + runtime +
                '}';
    }
}
