package edu.sa.td4.Question1;


public class Horsemen extends AbstractSoldier {
    private static final int FORCE_HORSEMEN = 2;

    public Horsemen(int vie) {
        super(vie);
    }

    public int hit() {
        System.out.println(toString() + " originally attack with " + FORCE_HORSEMEN + " force");
        return FORCE_HORSEMEN;
    }

    @Override
    public String toString() {
        return "Horsemen";
    }


}