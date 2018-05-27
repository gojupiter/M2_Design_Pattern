package edu.sa.td4.Question1;

public class Main {

    public static void main(String[] args) {
        Soldier c = new ProxyHorsemen(100);
        Soldier f = new ProxyInfantrymen(50);
        int ncoups = 0;
        boolean v1 = true;
        boolean v2 = true;
        Soldier horsemanWhoHaveOneShield = new ProxyHorsemen(100);
//        horsemanWhoHaveOneShield.addShield();

        Soldier infantrymenWhoHaveOneSwordAndOneShield = new ProxyInfantrymen(50);
//        infantrymenWhoHaveOneSwordAndOneShield.addShield();
//        infantrymenWhoHaveOneSwordAndOneShield.addSword();

        Group army1 = new Group();
        army1.addSoldier(c);
        army1.addSoldier(f);

        Group army2 = new Group();
        army2.addSoldier(horsemanWhoHaveOneShield);
        army2.addSoldier(infantrymenWhoHaveOneSwordAndOneShield);
        army2.addShield();
        army2.addSword();

//        for (; (v1 = army1.wardOff(army2.hit()))
//                && (v2 = army2.wardOff(army1.hit())); ncoups++ )
//            ;

        while(v1 && v2){
            ncoups++;
            System.out.println("**********************************************");
            System.out.println("*****************Army2 attack*****************");
            System.out.println();
            v1 = army1.wardOff(army2.hit());
            System.out.println();
            System.out.println("**********************************************");
            System.out.println("**********************************************");
            System.out.println();
            System.out.println();

            System.out.println("**********************************************");
            System.out.println("*****************Army1 attack*****************");
            System.out.println();
            v2 = army2.wardOff(army1.hit());
            System.out.println();
            System.out.println("**********************************************");
            System.out.println("**********************************************");

        }
        System.out.println("Death of the " + (v1 ? " army 2 " : "army 1")
                + " in " + ncoups + " shots");
    }
}