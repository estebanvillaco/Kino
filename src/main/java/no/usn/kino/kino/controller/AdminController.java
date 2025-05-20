package no.usn.kino.kino.controller;

import no.usn.kino.kino.service.LoginService;
import no.usn.kino.kino.session.BrukerSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final BrukerSession session;
    private final LoginService loginService;

    public AdminController(BrukerSession session, LoginService loginService) {
        this.session = session;
        this.loginService = loginService;
    }

    @PutMapping("/endre-pin")
    public ResponseEntity<?> endrePin(@RequestParam String brukernavn, @RequestParam int nyPin) {
        if (!session.harRolle("admin")) {
            return ResponseEntity.status(403).body("Bare admin kan endre PIN");
        }
        boolean resultat = loginService.endrePin(brukernavn, nyPin);
        return resultat
                ? ResponseEntity.ok("PIN oppdatert")
                : ResponseEntity.badRequest().body("Bruker ikke funnet");
    }
}

