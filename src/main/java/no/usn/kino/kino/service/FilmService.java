package no.usn.kino.kino.service;


import no.usn.kino.kino.model.Film;
import no.usn.kino.kino.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> hentAlleFilmer() {
        return filmRepository.findAll();
    }

    public Optional<Film> hentFilmMedId(int id) {
        return filmRepository.findById(id);
    }

    public Film lagreFilm(Film film) {
        return filmRepository.save(film);
    }

    public void slettFilm(int id) {
        filmRepository.deleteById(id);
    }
}

