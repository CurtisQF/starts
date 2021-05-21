package org.launchcode.starts.models;

public enum State {

    MO("MO"),
    IL("IL");

    private final String displayName;

    State(String displayName) { this.displayName = displayName; }

    public String getDisplayName() {return displayName; }
}
