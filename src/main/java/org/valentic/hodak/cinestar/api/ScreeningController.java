package org.valentic.hodak.cinestar.api;

import org.valentic.hodak.cinestar.model.Screening;
import org.valentic.hodak.cinestar.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {

    @Autowired
    public ScreeningService screeningService;

    @GetMapping
    public ResponseEntity<List<Screening>> getAllScreening() {
        List<Screening> screenings = screeningService.getAllScreenings();
        return ResponseEntity.ok(screenings);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteScreeningById(@PathVariable Long id) {
        Screening screening = screeningService.getScreeningById(id);
        if (screening != null) {
            screeningService.deleteScreening(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
