package no.usn.kino.kino.repository;


import no.usn.kino.kino.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Finner en bruker basert på brukernavn (l_brukernavn er primærnøkkel)
    User findByBrukernavn(String brukernavn);
}