package no.usn.kino.kino.model;


import java.io.Serializable;
import java.util.Objects;

public class PlassBillettId implements Serializable {

    private String billettkode;
    private int radnr;
    private int setenr;
    private int kinosalnr;

    public PlassBillettId() {}

    public PlassBillettId(String billettkode, int radnr, int setenr, int kinosalnr) {
        this.billettkode = billettkode;
        this.radnr = radnr;
        this.setenr = setenr;
        this.kinosalnr = kinosalnr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlassBillettId that)) return false;
        return radnr == that.radnr &&
                setenr == that.setenr &&
                kinosalnr == that.kinosalnr &&
                Objects.equals(billettkode, that.billettkode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billettkode, radnr, setenr, kinosalnr);
    }
}

