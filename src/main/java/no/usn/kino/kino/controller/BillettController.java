package no.usn.kino.kino.controller;

import no.usn.kino.kino.model.Billett;
import no.usn.kino.kino.service.BillettService;
import no.usn.kino.kino.session.BrukerSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billetter")
public class BillettController {

    private final BillettService billettService;
    private final BrukerSession session;

    public BillettController(BillettService billettService, BrukerSession session) {
        this.billettService = billettService;
        this.session = session;
    }

    @GetMapping
    public List<Billett> hentAlle() {
        return billettService.hentAlle();
    }

    @PostMapping("/{visningsnr}")
    public ResponseEntity<?> opprett(@PathVariable int visningsnr) {
        if (!session.harRolle("betjent")) {
            return ResponseEntity.status(403).body("Tilgang nektet: Krever rolle betjent");
        }
        Billett billett = billettService.opprettBillett(visningsnr);
        return ResponseEntity.ok(billett);
    }

    @PostMapping("/betal/{kode}")
    public ResponseEntity<?> betal(@PathVariable String kode) {
        if (!session.harRolle("betjent")) {
            return ResponseEntity.status(403).body("Tilgang nektet: Krever rolle betjent");
        }
        Billett oppdatert = billettService.bekreftBetaling(kode);
        if (oppdatert != null) {
            return ResponseEntity.ok(oppdatert);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{kode}")
    public ResponseEntity<?> slett(@PathVariable String kode) {
        if (!session.harRolle("betjent")) {
            return ResponseEntity.status(403).body("Tilgang nektet: Krever rolle betjent");
        }
        billettService.slettBillett(kode);
        return ResponseEntity.noContent().build();
    }
}
