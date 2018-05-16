package com.company;

public class InfrantrymenProxy implements Soldier {
    private Soldier soldier;
    Equiment shield = new Equiment(0,10);
    Equiment sword = new Equiment(0,10);


    public InfrantrymenProxy(int vie) {
        this.soldier = new Infantrymen(vie);
    }

    @Override
    public int hit() {
        if (sword.getValue() > 0) sword.decreaseDuration();
        if (sword.getDuration() == 0) sword.decreaseValue();
        return soldier.hit()+sword.getValue();
    }

    @Override
    public boolean wardOff(int force) {
        if (shield.getValue() > 0) shield.decreaseDuration();
        if (shield.getDuration() == 0) shield.decreaseValue();
        return soldier.wardOff(force-shield.getValue());
    }

    public void addShield(){
        shield.increaseValue();
    }

    public void addSword(){
        sword.increaseValue();
    }
}
