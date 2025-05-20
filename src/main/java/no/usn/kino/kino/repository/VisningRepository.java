package no.usn.kino.kino.repository;

import no.usn.kino.kino.model.Visning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface VisningRepository extends JpaRepository<Visning, Integer> {
    List<Visning> findByDatoAndStarttidAfter(LocalDate dato, LocalTime tid);
    List<Visning> findByFilmnr(int filmnr);
}

