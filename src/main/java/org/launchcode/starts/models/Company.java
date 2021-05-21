package org.launchcode.starts.models;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company extends AbstractEntity{

    //    @OneTo...
    @NotNull
    private String promoter;

    @OneToMany(mappedBy = "company")
    private final List<Event> events = new ArrayList<>();

    @NotNull(message = "Company name required")
    @Size(min=2, max=50, message = "Company name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Art type required")
    private ArtType type;

    @NotNull(message = "Art level required")
    private ArtLevel level;

    private String phone;

    private String address;

    private String city;

    private State state;

    private String zipCode;

    @URL(message = "Complete URL with 'HTTP' required")
    private String URL;

    @Size(max=500, message="Description cannot be longer than 500 characters")
    private String description;

    //Constructors

    public Company () {}

    public Company(String promoter, String name, ArtType type, ArtLevel level, String phone, String address, String city, State state, String zipCode, String URL, String description) {
        this.promoter = promoter;
        this.name = name;
        this.type = type;
        this.level = level;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.URL = URL;
        this.description = description;
    }

    //Get-sets

    public String getPromoter() {
        return promoter;
    }

    public void setPromoter(String promoter) {
        this.promoter = promoter;
    }

    public List<Event> getEvents() {
        return events;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
