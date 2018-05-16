package com.company;

public class Main {

    public static void main(String[] args) {
        //Soldier c = new Horsemen(100);
        //Soldier f = new Infantrymen(50);
        //f = new ShieldSoldierDecor(f);
        //c = new SwordSoldierDecor(c);
        HorsemenProxy c = new HorsemenProxy(100);
        c.addShield();
        c.addSword();

        InfrantrymenProxy f = new InfrantrymenProxy(50);
        f.addShield();
        f.addSword();

        int ncoups = 0;
        boolean vc = true;
        boolean vf = true;

        for (; (vf = f.wardOff(c.hit())) && (vc = c.wardOff(f.hit())); ncoups++)
            ;

        System.out.println("Death of the " + (vf ? "Horsemen" : "Infantrymen")
                + " in " + ncoups + " shots");
    }
}