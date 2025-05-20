package no.usn.kino.kino.service;

import no.usn.kino.kino.model.Login;
import no.usn.kino.kino.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public String loggInn(String brukernavn, int pinkode) {
        logger.info("Attempting login with brukernavn: {}, pinkode: {}", brukernavn, pinkode);
        Login login = loginRepository.findByBrukernavnAndPinkode(brukernavn, pinkode);
        if (login != null) {
            logger.info("Login successful for user: {}", login);
            if ("root".equalsIgnoreCase(brukernavn)) {
                return "admin";
            } else if (login.isErPlanlegger()) {
                return "planlegger";
            } else {
                return "betjent";
            }
        }
        logger.warn("Login failed: No matching user found for brukernavn: {}, pinkode: {}", brukernavn, pinkode);
        return null;
    }

    public boolean endrePin(String brukernavn, int nyPin) {
        logger.info("Attempting to change PIN for brukernavn: {}", brukernavn);
        Login login = loginRepository.findById(brukernavn).orElse(null);
        if (login != null) {
            login.setPinkode(nyPin);
            loginRepository.save(login);
            logger.info("PIN successfully changed for brukernavn: {}", brukernavn);
            return true;
        }
        logger.warn("Failed to change PIN: User not found for brukernavn: {}", brukernavn);
        return false;
    }
}