package com.company;

public class ShieldSoldierDecor extends SoldierDecor {
    public ShieldSoldierDecor(Soldier soldier) {
        super(soldier);
    }

    @Override
    public boolean wardOff(int force) {
        return super.wardOff(force - 1);
    }
}
