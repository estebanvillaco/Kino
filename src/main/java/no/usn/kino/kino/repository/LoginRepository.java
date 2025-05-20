package no.usn.kino.kino.repository;

import no.usn.kino.kino.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, String> {
    Login findByBrukernavnAndPinkode(String brukernavn, int pinkode);
}