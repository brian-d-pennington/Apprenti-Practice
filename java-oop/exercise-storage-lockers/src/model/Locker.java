package model;

import java.util.Random;

public class Locker {
    // local variables
    private String lockerId;
    private boolean isOccupied;
    private String contents;
    private int random = (int)(Math.random() * 1) + 10;
    // constructor
    public Locker(String lockerId) {
        this.lockerId = Double.toString(random);
        this.isOccupied = false;
        this.contents = "";
    }
    // getters and setters

    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
    // methods

    public void storeItem(String item) {
        this.isOccupied = true;
        this.contents = item;
    }

    public void removeItem() {
        this.isOccupied = false;
        this.contents = "";
    }

    public String toString() {
        String occupiedMessage;
        if (isOccupied) {
            occupiedMessage = "is occupied";
        } else {
            occupiedMessage = "is free";
        }
        return "Locker " + this.lockerId + " " + occupiedMessage + " and contains " + this.contents;
    }
}
