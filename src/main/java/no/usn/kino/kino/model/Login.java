package no.usn.kino.kino.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tbllogin", schema = "kino")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Login {

    @Id
    @Column(name = "l_brukernavn")
    private String brukernavn;

    @Column(name = "l_pinkode")
    private int pinkode;

    @Column(name = "l_erpplanlegger")
    private boolean erPlanlegger;

    @Override
    public String toString() {
        return "Login{" +
                "brukernavn='" + brukernavn + '\'' +
                ", pinkode=" + pinkode +
                ", erPlanlegger=" + erPlanlegger +
                '}';
    }
}