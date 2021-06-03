package org.launchcode.starts.models;

import org.hibernate.validator.constraints.CodePointLength;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Event extends AbstractEntity{

    @ManyToOne
    @JoinColumn
    @NotNull
    private User user;

    @ManyToOne
    @NotNull(message = "Company required")
    private Company company;

    @NotNull(message = "Event name required")
    @Size(min=2, max=50, message = "Event name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Art type required")
    private ArtType type;

    @NotNull(message = "Art level required")
    private ArtLevel level;

    @NotNull(message = "Please enter a valid date/time")
    private String date1;

    private String date2;

    @PositiveOrZero(message = "Cannot be lower than $0")
    private int priceLow;

    @PositiveOrZero(message = "Cannot be lower than $0")
    private int priceHigh;

    @URL(message = "Complete URL with 'HTTP' required")
    private String URL;

    @Size(max=500, message="Description cannot be longer than 500 characters")
    private String description;

    //Constructors

    public Event() {}

    public Event(User user) {
        this.user = user;
    }

    public Event(User user, Company company, String name, ArtType type, ArtLevel level, String date1, String date2, int priceLow, int priceHigh, String URL, String description) {
        this.user = user;
        this.company = company;
        this.name = name;
        this.type = type;
        this.level = level;
        this.date1 = date1;
        this.date2 = date2;
        this.priceLow = priceLow;
        this.priceHigh = priceHigh;
        this.URL = URL;
        this.description = description;

    }

//Get-sets


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtType getType() {
        return type;
    }

    public void setType(ArtType type) {
        this.type = type;
    }

    public ArtLevel getLevel() {
        return level;
    }

    public void setLevel(ArtLevel level) {
        this.level = level;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public int getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(int priceLow) { this.priceLow = priceLow; }

    public int getPriceHigh() {
        return priceHigh;
    }

    public void setPriceHigh(int priceHigh) {
        this.priceHigh = priceHigh;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
