package no.usn.kino.kino.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tblfilm", schema = "kino")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_filmnr")
    private int filmnr;

    @Column(name = "f_filmnavn", nullable = false)
    private String filmnavn;

    // Konstruktører
    public Film() {}

    public Film(String filmnavn) {
        this.filmnavn = filmnavn;
    }

    // Gettere og settere

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getFilmnavn() {
        return filmnavn;
    }

    public void setFilmnavn(String filmnavn) {
        this.filmnavn = filmnavn;
    }
}
