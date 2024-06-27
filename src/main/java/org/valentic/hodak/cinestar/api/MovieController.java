package org.valentic.hodak.cinestar.api;

import jakarta.transaction.Transactional;
import org.valentic.hodak.cinestar.model.Movie;
import org.valentic.hodak.cinestar.model.Screening;
import org.valentic.hodak.cinestar.service.MovieService;
import org.valentic.hodak.cinestar.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    public MovieService movieService;


    @Autowired
    public ScreeningService screeningService;



    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> addMovie(@RequestBody Movie movie){
        // Perform screenings check
        for (Screening screening : movie.getScreenings()) {

            if(screening.getEndTime() == null){
                screening.setEndTime(screening.getStartTime().plusMinutes(30L + movie.getRuntime()));
            }

            Screening byStartTime = screeningService.getScreeningByStartTime(screening.getStartTime());


            if (screening.equals(byStartTime)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        movieService.storeMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PatchMapping("{id}/screenings")
    @Transactional
    public ResponseEntity<?> addScreening(@PathVariable Long id, @RequestBody List<Screening> screenings){
        Movie targetMovie = movieService.getMovie(id);

        if(targetMovie == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Screening> newList = new ArrayList<>();
        for (Screening movieScreening : targetMovie.getScreenings()) {
            newList.add(movieScreening);
            for (Screening screening : screenings) {
                if(screening.getEndTime() == null){
                    screening.setEndTime(screening.getStartTime().plusMinutes(30L + targetMovie.getRuntime()));
                }

                if(movieScreening.equals(screening)){
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
                else{
                    newList.add(screening);
                }
            }
        }

        targetMovie.setScreenings(newList);
        movieService.storeMovie(targetMovie);
        return new ResponseEntity<>(newList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getMovie(@PathVariable Long id){
        Movie movie = movieService.getMovie(id);

        if(movie == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
    }
}
