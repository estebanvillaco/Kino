package no.usn.kino.kino.controller;

import no.usn.kino.kino.dto.UserDto;
import no.usn.kino.kino.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestParam String brukernavn,
            @RequestParam String pinkode,
            @RequestParam String role) {
        try {
            UserDto userDto = userService.createUser(brukernavn, pinkode, role);
            return ResponseEntity.ok(userDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build(); // Changed from .body(null)
        }
    }

    // Delete a user
    @DeleteMapping("/{brukernavn}")
    public ResponseEntity<Void> deleteUser(@PathVariable String brukernavn) {
        try {
            userService.deleteUser(brukernavn);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Changed from .body(null)
        }
    }

    // Update a user's PIN
    @PutMapping("/{brukernavn}/pin")
    public ResponseEntity<UserDto> updatePin(
            @PathVariable String brukernavn,
            @RequestParam String pinkode) {
        try {
            UserDto updatedUser = userService.updatePin(brukernavn, pinkode);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Changed from .body(null)
        }
    }

    // Get user details
    @GetMapping("/{brukernavn}")
    public ResponseEntity<UserDto> getUser(@PathVariable String brukernavn) {
        try {
            UserDto userDto = userService.findUserDTO(brukernavn);
            return ResponseEntity.ok(userDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Changed from .body(null)
        }
    }
}