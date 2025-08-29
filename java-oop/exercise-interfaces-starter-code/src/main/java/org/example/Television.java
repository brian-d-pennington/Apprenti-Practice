package org.example;

public class Television implements Connectable {
    public boolean state;

    public Television() {
        this.state = false; // Off
    }

    public void turnOn() {
        this.state = true;
    }
    public void turnOff() {
        this.state = false;
    }
    public boolean getState() {
        return this.state;
    }
    public String getName() {
        return "Samsung X32LLC";
    }
}

