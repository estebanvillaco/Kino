package no.usn.kino.kino.controller;


import no.usn.kino.kino.model.PlassBillett;
import no.usn.kino.kino.service.PlassBillettService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plasser")
public class PlassBillettController {

    private final PlassBillettService plassBillettService;

    public PlassBillettController(PlassBillettService plassBillettService) {
        this.plassBillettService = plassBillettService;
    }

    @GetMapping("/kinosal/{salnr}")
    public List<PlassBillett> hentOpptattePlasser(@PathVariable int salnr) {
        return plassBillettService.hentAlleForKinosal(salnr);
    }

    @PostMapping("/registrer")
    public ResponseEntity<?> registrerPlasser(@RequestBody List<PlassBillett> plasser) {
        plassBillettService.lagrePlasser(plasser);
        return ResponseEntity.ok("Plasser registrert.");
    }
}
