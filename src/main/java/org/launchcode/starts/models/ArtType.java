package org.launchcode.starts.models;


public enum ArtType {

    DANCE("Dance"),
    MUSIC("Music"),
    THEATRE("Theatre");

    private final String displayName;

    ArtType(String displayName) { this.displayName = displayName; }

    public String getDisplayName() {return displayName; }
}
