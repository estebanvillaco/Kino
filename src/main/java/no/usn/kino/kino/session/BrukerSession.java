package no.usn.kino.kino.session;

import org.springframework.stereotype.Component;

@Component
public class BrukerSession {
    private String brukernavn;
    private String rolle;

    public void loggInn(String brukernavn, String rolle) {
        this.brukernavn = brukernavn;
        this.rolle = rolle;
    }

    public void loggUt() {
        this.brukernavn = null;
        this.rolle = null;
    }

    public boolean harRolle(String ønsketRolle) {
        return rolle != null && rolle.equalsIgnoreCase(ønsketRolle);
    }

    public boolean erLoggetInn() {
        return brukernavn != null;
    }

    public String getRolle() {
        return rolle;
    }

    public String getBrukernavn() {
        return brukernavn;
    }
}
