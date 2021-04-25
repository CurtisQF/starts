package org.launchcode.starts.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity{

    @NotNull(message = "Event name required")
    @Size(min=2, max=50, message = "Event name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Art type required")
    private ArtType type;



    //Constructors

    public Event() {}

    public Event(String name, ArtType type) {
        this.name = name;
        this.type = type;
    }


    //Get-sets

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
}
