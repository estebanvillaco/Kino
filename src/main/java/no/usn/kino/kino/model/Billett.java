package no.usn.kino.kino.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tblbillett", schema = "kino")
public class Billett {

    @Id
    @Column(name = "b_billettkode", length = 6)
    private String billettkode;

    @Column(name = "b_visningsnr", nullable = false)
    private int visningsnr;

    @Column(name = "b_erBetalt", nullable = false)
    private boolean erBetalt;

    public Billett() {}

    public Billett(String billettkode, int visningsnr, boolean erBetalt) {
        this.billettkode = billettkode;
        this.visningsnr = visningsnr;
        this.erBetalt = erBetalt;
    }

    public String getBillettkode() {
        return billettkode;
    }

    public void setBillettkode(String billettkode) {
        this.billettkode = billettkode;
    }

    public int getVisningsnr() {
        return visningsnr;
    }

    public void setVisningsnr(int visningsnr) {
        this.visningsnr = visningsnr;
    }

    public boolean isErBetalt() {
        return erBetalt;
    }

    public void setErBetalt(boolean erBetalt) {
        this.erBetalt = erBetalt;
    }
}

