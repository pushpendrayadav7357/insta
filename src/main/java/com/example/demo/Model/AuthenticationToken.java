package com.example.demo.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private LocalDate tokenCreationDate;

    @OneToOne
    private User user;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDate getTokenCreationDate() {
        return tokenCreationDate;
    }

    public void setTokenCreationDate(LocalDate tokenCreationDate) {
        this.tokenCreationDate = tokenCreationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
