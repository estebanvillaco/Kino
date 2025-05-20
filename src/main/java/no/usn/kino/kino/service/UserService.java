package no.usn.kino.kino.service;

import no.usn.kino.kino.model.User;
import no.usn.kino.kino.dto.UserDto;
import no.usn.kino.kino.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public User login(String brukernavn, String pinkode) {
        User user = userRepository.findByBrukernavn(brukernavn);
        if (user != null && passwordEncoder.matches(pinkode, user.getPinkode())) {
            return user;
        }
        return null;
    }

    @Transactional(readOnly = true)
    public User findUser(String brukernavn) {
        return userRepository.findByBrukernavn(brukernavn);
    }

    @Transactional
    public UserDto createUser(String brukernavn, String pinkode, String role) {
        if (userRepository.findByBrukernavn(brukernavn) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        User user = new User();
        user.setBrukernavn(brukernavn);
        user.setPinkode(passwordEncoder.encode(pinkode));
        user.setRole(role);
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getBrukernavn(), savedUser.getRole());
    }

    @Transactional
    public void deleteUser(String brukernavn) {
        userRepository.deleteById(brukernavn);
    }

    @Transactional
    public UserDto updatePin(String brukernavn, String newPinkode) {
        User user = userRepository.findByBrukernavn(brukernavn);
        if (user != null) {
            user.setPinkode(passwordEncoder.encode(newPinkode));
            User updatedUser = userRepository.save(user);
            return new UserDto(updatedUser.getBrukernavn(), updatedUser.getRole());
        }
        throw new IllegalArgumentException("User not found");
    }

    @Transactional(readOnly = true)
    public UserDto findUserDTO(String brukernavn) {
        User user = userRepository.findByBrukernavn(brukernavn);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return new UserDto(user.getBrukernavn(), user.getRole());
    }
}