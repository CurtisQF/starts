package org.launchcode.starts.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //Constructor

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    //Get-set

    public String getUsername() {
        return username;
    }

    //Methods

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}
