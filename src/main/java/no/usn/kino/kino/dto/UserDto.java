package no.usn.kino.kino.dto;

public class UserDto {
    private String brukernavn;
    private String role; // Changed from Boolean erPlanlegger to String role

    // Default constructor
    public UserDto() {}

    // Constructor for mapping from User entity
    public UserDto(String brukernavn, String role) {
        this.brukernavn = brukernavn;
        this.role = role;
    }

    // Getters and setters
    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}