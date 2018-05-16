package com.company;

public class Equiment {
    private int value;
    private int duration;

    public Equiment(int value, int duration) {
        this.value = value;
        this.duration = duration;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getValue() {

        return value;
    }

    public int getDuration() {
        return duration;
    }
    public void decreaseDuration(){
        this.duration--;
    }
    public void increaseValue(){
        this.value++;
    }
    public void decreaseValue(){
        this.value++;
    }
}
