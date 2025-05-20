package no.usn.kino.kino.controller;

import no.usn.kino.kino.model.Film;
import no.usn.kino.kino.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmer")
public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    public List<Film> hentAlleFilmer() {
        return filmService.hentAlleFilmer();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> hentFilmMedId(@PathVariable int id) {
        return filmService.hentFilmMedId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Film lagNyFilm(@RequestBody Film film) {
        return filmService.lagreFilm(film);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> slettFilm(@PathVariable int id) {
        filmService.slettFilm(id);
        return ResponseEntity.noContent().build();
    }
}
