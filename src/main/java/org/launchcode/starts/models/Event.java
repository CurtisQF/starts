package org.launchcode.starts.models;

import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Event extends AbstractEntity{

    private static final String DATE_FORMAT_PATTERN = "MM/dd/yyyy";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT_PATTERN);

    //    @OneToMany
    @NotNull
    private String promoter;

    //    @OneToMany
    @NotNull(message = "Company required")
    private String company;

    @NotNull(message = "Event name required")
    @Size(min=2, max=50, message = "Event name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Art type required")
    private ArtType type;

    @NotNull(message = "Art level required")
    private ArtLevel level;

    @Size(max=500, message="Description cannot be larger than 500 characters.")
    private String description;

    @NotNull(message = "Event start date required")
    @DateTimeFormat(pattern = DATE_FORMAT_PATTERN)
    private Date startDate;

    @DateTimeFormat(pattern = DATE_FORMAT_PATTERN)
    private Date endDate;

    @PositiveOrZero(message = "Cannot be lower than $0.")
    private int priceLow;

    @PositiveOrZero(message = "Cannot be lower than $0.")
    private int priceHigh;

    @URL(message = "Invalid URL")
    private String URL;


    //Constructors

    public Event() {}

    public Event(String promoter, String company, String name, ArtType type, ArtLevel level, String description, Date startDate, Date endDate, int priceLow, int priceHigh, String URL) {
        this.promoter = promoter;
        this.company = company;
        this.name = name;
        this.type = type;
        this.level = level;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceLow = priceLow;
        this.priceHigh = priceHigh;
        this.URL = URL;
    }

//Get-sets

    public String getPromoter() {
        return promoter;
    }

    public void setPromoter(String promoter) {
        this.promoter = promoter;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(int priceLow) {
        this.priceLow = priceLow;
    }

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
}
