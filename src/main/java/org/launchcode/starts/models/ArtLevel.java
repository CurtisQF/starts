package org.launchcode.starts.models;

public enum ArtLevel {

    YOUTH("Youth"),
    COLLEGIATE("Collegiate"),
    COMMUNITY("Community"),
    PROFESSIONAL("Professional");

    private final String displayName;

    ArtLevel(String displayName) { this.displayName = displayName; }

    public String getDisplayName() {return displayName; }
}
