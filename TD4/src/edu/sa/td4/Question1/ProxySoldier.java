package edu.sa.td4.Question1;

abstract class ProxySoldier implements Soldier {
    protected int vie;

    ProxySoldier(int vie) {
        this.vie = vie;
    }

    public boolean wardOff(int force) {
        vie = (vie > force) ? vie - force : 0;
        System.out.println("=========================================================");
        System.out.println(toString() + " is attacked with " + force + " force");
        System.out.println(toString() + " now have " + vie + " vie");
        System.out.println("=========================================================");
        System.out.println();
        return vie > 0;
    }

    public abstract void addShield();

    public abstract void addSword();
}