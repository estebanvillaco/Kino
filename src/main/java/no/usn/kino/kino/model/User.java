package no.usn.kino.kino.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbllogin", schema = "kino")
public class User {

    @Id
    @Column(name = "l_brukernavn")
    private String brukernavn;

    @Column(name = "l_pinkode")
    private String pinkode; // Endret til String for å støtte hashede PIN-koder

    @Column(name = "l_role") // Ny kolonne for roller
    private String role;

    // Default constructor (required by JPA)
    public User() {}

    // Getters and setters
    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getPinkode() {
        return pinkode;
    }

    public void setPinkode(String pinkode) {
        this.pinkode = pinkode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}