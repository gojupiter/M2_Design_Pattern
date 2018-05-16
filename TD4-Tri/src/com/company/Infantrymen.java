package com.company;

public class Infantrymen extends AbstractSoldier {
    private static final int FORCE_INFANTRYMEN = 1;

    public Infantrymen(int vie) {
        super(vie);
    }

    public int hit() {
        return FORCE_INFANTRYMEN;
    }
}