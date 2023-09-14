package com.mycompany.buisness;


public class MeetingRoom {
    private String roomId;
    private String name;
    private int seatingCapacity;
    private int perHourCost; 
    private boolean hasProjector;
    private boolean hasWiFi;
    private boolean hasConferenceCallFacility;
    private boolean hasWhiteboard;
    private boolean hasWaterDispenser;
    private boolean hasTV;
    private boolean hasCoffeeMachine;

    public MeetingRoom(String name, int seatingCapacity, boolean hasProjector, boolean hasWiFi, 
            boolean hasConferenceCallFacility, boolean hasWhiteboard, 
            boolean hasWaterDispenser, boolean hasTV, boolean hasCoffeeMachine) {
this.name = name;
this.seatingCapacity = seatingCapacity;
this.hasProjector = hasProjector;
this.hasWiFi = hasWiFi;
this.hasConferenceCallFacility = hasConferenceCallFacility; 
this.hasWhiteboard = hasWhiteboard;
this.hasWaterDispenser = hasWaterDispenser;
this.hasTV = hasTV;
this.hasCoffeeMachine = hasCoffeeMachine;
}
    public MeetingRoom(String roomId, String name, int seatingCapacity) {
        this.roomId = roomId;
        this.name = name;
        this.seatingCapacity = seatingCapacity;
        // Initialize other attributes
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getPerHourCost() {
        return perHourCost;
    }

    public void setPerHourCost(int perHourCost) {
        this.perHourCost = perHourCost;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public boolean isHasWiFi() {
        return hasWiFi;
    }

    public void setHasWiFi(boolean hasWiFi) {
        this.hasWiFi = hasWiFi;
    }

    public boolean isHasConferenceCall() {
        return hasConferenceCallFacility;
    }

    public void setHasConferenceCall(boolean hasConferenceCall) {
        this.hasConferenceCallFacility = hasConferenceCall;
    }

    public boolean isHasWhiteboard() {
        return hasWhiteboard;
    }

    public void setHasWhiteboard(boolean hasWhiteboard) {
        this.hasWhiteboard = hasWhiteboard;
    }

    public boolean isHasWaterDispenser() {
        return hasWaterDispenser;
    }

    public void setHasWaterDispenser(boolean hasWaterDispenser) {
        this.hasWaterDispenser = hasWaterDispenser;
    }

    public boolean isHasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    public boolean isHasCoffeeMachine() {
        return hasCoffeeMachine;
    }

    public void setHasCoffeeMachine(boolean hasCoffeeMachine) {
        this.hasCoffeeMachine = hasCoffeeMachine;
    }
}
