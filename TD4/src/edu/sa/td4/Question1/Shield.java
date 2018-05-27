package edu.sa.td4.Question1;

public class Shield extends Weapon {
    private static final int FORCE_SHIELD = 2;
    private static final int VIE_SHIELD = 100;
    public Shield(){
        super(FORCE_SHIELD, VIE_SHIELD);
    }

    @Override
    public String toString() {
        return "Shield";
    }
}
