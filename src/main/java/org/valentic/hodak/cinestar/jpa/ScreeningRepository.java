package org.valentic.hodak.cinestar.jpa;

import org.valentic.hodak.cinestar.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
    Screening findByStartTime(LocalDateTime startTime);
}
