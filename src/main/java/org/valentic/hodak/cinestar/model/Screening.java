package org.valentic.hodak.cinestar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "screening")
public class Screening {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(name = "hall", nullable = false)
    private String hall;
    @Column(name = "startTime", nullable = false)
    private LocalDateTime startTime;
    @Column(name = "endTime")
    private LocalDateTime endTime;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "movieId")
    private Movie movie;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getHall() {
        return hall;
    }
    public void setHall(String hall) {
        this.hall = hall;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screening screening = (Screening) o;
        return Objects.equals(getHall(), screening.getHall()) && Objects.equals(getStartTime(), screening.getStartTime()) && Objects.equals(getEndTime(), screening.getEndTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHall(), getStartTime(), getEndTime());
    }

    @Override
    public String toString() {
        return "Screening{" +
                "screeningId=" + id +
                ", hall='" + hall + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
//                ", movie=" + movie +
                '}';
    }
}
