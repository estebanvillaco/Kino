package no.usn.kino.kino.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tblplassbillett", schema = "kino")
@IdClass(PlassBillettId.class)
public class PlassBillett {

    @Id
    @Column(name = "pb_billettkode", length = 6)
    private String billettkode;

    @Id
    @Column(name = "pb_radnr")
    private int radnr;

    @Id
    @Column(name = "pb_setenr")
    private int setenr;

    @Id
    @Column(name = "pb_kinosalnr")
    private int kinosalnr;

    public PlassBillett() {}

    public PlassBillett(String billettkode, int radnr, int setenr, int kinosalnr) {
        this.billettkode = billettkode;
        this.radnr = radnr;
        this.setenr = setenr;
        this.kinosalnr = kinosalnr;
    }

    public String getBillettkode() {
        return billettkode;
    }

    public int getRadnr() {
        return radnr;
    }

    public int getSetenr() {
        return setenr;
    }

    public int getKinosalnr() {
        return kinosalnr;
    }

    public void setBillettkode(String billettkode) {
        this.billettkode = billettkode;
    }

    public void setRadnr(int radnr) {
        this.radnr = radnr;
    }

    public void setSetenr(int setenr) {
        this.setenr = setenr;
    }

    public void setKinosalnr(int kinosalnr) {
        this.kinosalnr = kinosalnr;
    }
}
