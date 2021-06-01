package org.launchcode.starts.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull
    @NotBlank
    @Email(message = "Invalid email address")
    private String username;

    @NotNull
    @NotBlank
    @Size(min=8, max=30, message = "Password must be between 8 and 30 characters")
    private String password;

    //Get-set

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
