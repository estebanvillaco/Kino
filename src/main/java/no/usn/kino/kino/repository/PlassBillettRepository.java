package no.usn.kino.kino.repository;

import no.usn.kino.kino.model.PlassBillett;
import no.usn.kino.kino.model.PlassBillettId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlassBillettRepository extends JpaRepository<PlassBillett, PlassBillettId> {

    // Riktig rekkefølge og typer:
    List<PlassBillett> findByKinosalnrAndBillettkode(int kinosalnr, String billettkode);

    List<PlassBillett> findByKinosalnr(int kinosalnr);

    List<PlassBillett> findByBillettkode(String billettkode);
}
