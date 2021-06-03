package org.launchcode.starts.models.dto;

import org.launchcode.starts.models.Company;
import org.launchcode.starts.models.User;
import javax.validation.constraints.NotNull;

public class CompanyUserDTO {

    @NotNull
    private Company company;

    @NotNull
    private User user;

    public CompanyUserDTO() {}

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
