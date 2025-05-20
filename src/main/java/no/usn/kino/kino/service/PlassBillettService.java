package no.usn.kino.kino.service;


import no.usn.kino.kino.model.PlassBillett;
import no.usn.kino.kino.repository.PlassBillettRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlassBillettService {

    private final PlassBillettRepository plassBillettRepository;

    public PlassBillettService(PlassBillettRepository plassBillettRepository) {
        this.plassBillettRepository = plassBillettRepository;
    }

    public List<PlassBillett> hentAlleForKinosal(int kinosalnr) {
        return plassBillettRepository.findByKinosalnr(kinosalnr);
    }

    public List<PlassBillett> hentAlleForBillett(String billettkode) {
        return plassBillettRepository.findByBillettkode(billettkode);
    }

    public void lagrePlasser(List<PlassBillett> plasser) {
        plassBillettRepository.saveAll(plasser);
    }
}

