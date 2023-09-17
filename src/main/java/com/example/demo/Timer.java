package com.example.demo;

public class Timer {

    boolean isRunning = false;
    private int hours;
    private int minutes;
    private int seconds;

    String getCurrentTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    void runSeconds() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }
        if (minutes == 60) {
            minutes = 0;
            hours++;
        }
        if(hours == 24){
            hours = 0;
        }
    }

    void reset() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
}
