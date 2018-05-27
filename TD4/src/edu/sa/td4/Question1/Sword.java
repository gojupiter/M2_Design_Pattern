package edu.sa.td4.Question1;

public class Sword extends Weapon {
    private static final int FORCE_SWORD = 2;
    private static final int VIE_SWORD = 50;

    public Sword(){
        super(FORCE_SWORD, VIE_SWORD);
    }

    @Override
    public String toString() {
        return "Sword";
    }
}
