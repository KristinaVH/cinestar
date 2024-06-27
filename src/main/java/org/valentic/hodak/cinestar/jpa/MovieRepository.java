package org.valentic.hodak.cinestar.jpa;

import org.valentic.hodak.cinestar.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
