package no.usn.kino.kino.service;

import no.usn.kino.kino.model.Visning;
import no.usn.kino.kino.repository.VisningRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class VisningService {

    private final VisningRepository visningRepository;

    public VisningService(VisningRepository visningRepository) {
        this.visningRepository = visningRepository;
    }

    public List<Visning> hentAlleVisninger() {
        return visningRepository.findAll();
    }

    public Optional<Visning> hentMedId(int id) {
        return visningRepository.findById(id);
    }

    public Visning lagre(Visning visning) {
        return visningRepository.save(visning);
    }

    public void slett(int id) {
        visningRepository.deleteById(id);
    }

    public List<Visning> hentKommendeVisninger(LocalDate dato, LocalTime etterTid) {
        return visningRepository.findByDatoAndStarttidAfter(dato, etterTid);
    }
}

