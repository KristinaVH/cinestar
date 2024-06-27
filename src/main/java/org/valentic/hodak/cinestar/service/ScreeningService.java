package org.valentic.hodak.cinestar.service;

import org.valentic.hodak.cinestar.jpa.ScreeningRepository;
import org.valentic.hodak.cinestar.model.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    public ScreeningRepository screeningRepo;

    public List<Screening> getAllScreenings() {
        return screeningRepo.findAll();
    }

    public Screening getScreeningByStartTime(LocalDateTime startTime) {
        return screeningRepo.findByStartTime(startTime);
    }

    public Screening getScreeningById(Long id) {
        return screeningRepo.findById(id).orElse(null);
    }

    public List<Screening> createScreenings(List<Screening> screenings) {
        return screeningRepo.saveAll(screenings);
    }

    public void deleteScreening(Long screeningId) {
        screeningRepo.deleteById(screeningId);
    }
}
