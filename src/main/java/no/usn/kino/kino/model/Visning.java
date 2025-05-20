package no.usn.kino.kino.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tblvisning", schema = "kino")
public class Visning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "v_visningnr")
    private int visningnr;

    @Column(name = "v_filmnr", nullable = false)
    private int filmnr;

    @Column(name = "v_kinosalnr", nullable = false)
    private int kinosalnr;

    @Column(name = "v_dato", nullable = false)
    private LocalDate dato;

    @Column(name = "v_starttid", nullable = false)
    private LocalTime starttid;

    @Column(name = "v_pris", nullable = false)
    private BigDecimal pris;

    // Getters og setters

    public int getVisningnr() {
        return visningnr;
    }

    public void setVisningnr(int visningnr) {
        this.visningnr = visningnr;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public int getKinosalnr() {
        return kinosalnr;
    }

    public void setKinosalnr(int kinosalnr) {
        this.kinosalnr = kinosalnr;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public LocalTime getStarttid() {
        return starttid;
    }

    public void setStarttid(LocalTime starttid) {
        this.starttid = starttid;
    }

    public BigDecimal getPris() {
        return pris;
    }

    public void setPris(BigDecimal pris) {
        this.pris = pris;
    }
}
