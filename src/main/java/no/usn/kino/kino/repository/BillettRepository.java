package no.usn.kino.kino.repository;


import no.usn.kino.kino.model.Billett;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillettRepository extends JpaRepository<Billett, String> {
    List<Billett> findByErBetaltFalse();
}
