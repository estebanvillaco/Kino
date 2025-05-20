package no.usn.kino.kino.service;

import no.usn.kino.kino.model.Billett;
import no.usn.kino.kino.repository.BillettRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BillettService {

    private final BillettRepository billettRepository;

    public BillettService(BillettRepository billettRepository) {
        this.billettRepository = billettRepository;
    }

    public List<Billett> hentAlle() {
        return billettRepository.findAll();
    }

    public Optional<Billett> hentMedKode(String kode) {
        return billettRepository.findById(kode);
    }

    public Billett opprettBillett(int visningsnr) {
        String kode = genererUnikKode();
        Billett billett = new Billett(kode, visningsnr, false);
        return billettRepository.save(billett);
    }

    public Billett bekreftBetaling(String kode) {
        Optional<Billett> optional = billettRepository.findById(kode);
        if (optional.isPresent()) {
            Billett billett = optional.get();
            billett.setErBetalt(true);
            return billettRepository.save(billett);
        }
        return null;
    }

    public void slettBillett(String kode) {
        billettRepository.deleteById(kode);
    }

    /**
     * Sletter alle ubetalte billetter for en gitt visning dersom det er mindre enn 30 min igjen.
     * Returnerer -1 hvis for tidlig å slette.
     */
    public int slettUbetalteBilletterForVisning(int visningsnr, LocalDate visningsdato, LocalTime visningstid) {
        LocalDate idag = LocalDate.now();
        LocalTime nå = LocalTime.now();

        // Sjekk om visningen starter innen 30 minutter
        if (!visningsdato.equals(idag) || visningstid.minusMinutes(30).isAfter(nå)) {
            return -1; // For tidlig å slette
        }

        List<Billett> alle = billettRepository.findAll();
        List<Billett> ubetalte = alle.stream()
                .filter(b -> b.getVisningsnr() == visningsnr && !b.isErBetalt())
                .collect(Collectors.toList());

        // Logg og slett
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("slettinger.dat", true))) {
            for (Billett b : ubetalte) {
                writer.write("Slettet billettkode: " + b.getBillettkode() + "\n");
                billettRepository.delete(b);
            }
        } catch (IOException e) {
            System.err.println("Feil ved skriving til slettinger.dat: " + e.getMessage());
        }

        return ubetalte.size();
    }

    private String genererUnikKode() {
        String tegn = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand = new Random();
        String kode;
        do {
            kode = rand.ints(6, 0, tegn.length())
                    .mapToObj(i -> "" + tegn.charAt(i))
                    .reduce("", String::concat);
        } while (billettRepository.existsById(kode));
        return kode;
    }
}
