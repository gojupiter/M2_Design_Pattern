package com.company;

public class SwordSoldierDecor extends SoldierDecor {
    public SwordSoldierDecor(Soldier soldier) {
        super(soldier);
    }

    @Override
    public int hit() {
        return super.hit() + 1;
    }
}
