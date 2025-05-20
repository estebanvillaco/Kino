package no.usn.kino.kino.controller;

import no.usn.kino.kino.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<String> loggInn(@RequestParam String brukernavn, @RequestParam int pinkode) {
        String rolle = loginService.loggInn(brukernavn, pinkode);
        if (rolle != null) {
            return ResponseEntity.ok(rolle);
        } else {
            return ResponseEntity.status(401).body("Feil brukernavn eller PIN");
        }
    }
}