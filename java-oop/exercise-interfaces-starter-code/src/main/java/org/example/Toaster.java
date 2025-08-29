package org.example;

public class Toaster implements Connectable{
    boolean state = false;

    public Toaster() {
        this.state = false;
    }

    public void turnOn(){
        this.state = true;
    }

    public void turnOff(){
        this.state = false;
    }
    public boolean getState(){
        return this.state;
    }
    public String getName(){
        return "General Electric";
    }
}

