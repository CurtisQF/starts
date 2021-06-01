package org.launchcode.starts.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

    @NotNull
    @Email
    private String username;

    @NotNull
    private String pwHash;

    //Constructor

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = password;
    }

    //Get-set

    public String getUsername() {
        return username;
    }
}
