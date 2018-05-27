package edu.sa.td4.Question1;

public class Infantrymen extends AbstractSoldier {
    private static final int FORCE_INFANTRYMEN = 1;

    public Infantrymen(int vie) {
        super(vie);
    }

    public int hit() {
        System.out.println(toString() + " originally attack with " + FORCE_INFANTRYMEN + " force");
        return FORCE_INFANTRYMEN;
    }

    @Override
    public String toString() {
        return "Infantrymen";
    }
}