package no.usn.kino.kino.controller;

import no.usn.kino.kino.model.Visning;
import no.usn.kino.kino.service.VisningService;
import no.usn.kino.kino.session.BrukerSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/visninger")
public class VisningController {

    private final VisningService visningService;
    private final BrukerSession session;

    public VisningController(VisningService visningService, BrukerSession session) {
        this.visningService = visningService;
        this.session = session;
    }

    @GetMapping
    public List<Visning> hentAlle() {
        return visningService.hentAlleVisninger();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visning> hentMedId(@PathVariable int id) {
        return visningService.hentMedId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/kommende")
    public List<Visning> hentKommendeVisninger() {
        LocalDate idag = LocalDate.now();
        LocalTime grense = LocalTime.now().plusMinutes(30);
        return visningService.hentKommendeVisninger(idag, grense);
    }

    @PostMapping
    public ResponseEntity<?> lagre(@RequestBody Visning visning) {
        if (!session.harRolle("planlegger")) {
            return ResponseEntity.status(403).body("Tilgang nektet: Krever rolle planlegger");
        }
        return ResponseEntity.ok(visningService.lagre(visning));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> slett(@PathVariable int id) {
        if (!session.harRolle("planlegger")) {
            return ResponseEntity.status(403).body("Tilgang nektet: Krever rolle planlegger");
        }
        visningService.slett(id);
        return ResponseEntity.noContent().build();
    }
}
