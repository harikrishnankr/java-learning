package com.tutorials.advanced.designpatterns.behavioral;

public class Light {
    private boolean on = false;

    public void on() {
        on = true;
    }

    public void off() {
        on = false;
    }

    public boolean isOn() {
        return on;
    }
}
