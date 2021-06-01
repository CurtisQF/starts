package org.launchcode.starts.models.dto;

public class RegisterFormDTO extends LoginFormDTO {

    private String verifyPassword;

    //Get-set

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
