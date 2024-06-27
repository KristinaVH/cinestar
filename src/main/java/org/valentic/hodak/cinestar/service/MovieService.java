package org.valentic.hodak.cinestar.service;

import org.valentic.hodak.cinestar.jpa.MovieRepository;
import org.valentic.hodak.cinestar.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    public MovieRepository movieRepo;

    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    public Movie getMovie(long id) {
        return movieRepo.findById(id).orElse(null);
    }

    public Movie storeMovie(Movie movie) {
        movieRepo.save(movie);
        return movie;
    }
}
