

public class Main {

    public static void main(String[] args) {
    	// decorator
//        Soldier c = new Horsemen(100);
//        Soldier f = new Infantrymen(50);
//        f = new SoldierDecoratorShield(f);
//        c = new SoldierDecoratorSword(c);
    	// proxy 
//    	HorsemenProxy c = new HorsemenProxy(100);
//    	InfantrymenProxy f = new InfantrymenProxy(100);
//        c.INeedMorePower(5);
//        c.INeedMorePower(5);
//        c.INeedMoreDefense(100);
//        f.INeedMoreDefense(5);
        // composite
        ArmyGroup group1 = new ArmyGroup();
        ArmyGroup group2 = new ArmyGroup();
        ArmyGroup group3 = new ArmyGroup();
        
        group1.addSoldier(new HorsemenProxy(78));
        group1.addSoldier(new HorsemenProxy(45));
        group1.addSoldier(new HorsemenProxy(87));
        
        group2.addSoldier(new InfantrymenProxy(66));
        group2.addSoldier(new InfantrymenProxy(98));
        group2.addSoldier(new InfantrymenProxy(11));
        
        group3.addSoldier(new InfantrymenProxy(32));
        group3.addSoldier(new HorsemenProxy(44));
        group3.addSubGroup(group1);
        group3.addSubGroup(group2);
        group3.addSoldier(new HorsemenProxy(87));
        
        ArmyGroup group4 = new ArmyGroup();
        ArmyGroup group5 = new ArmyGroup();
        ArmyGroup group6 = new ArmyGroup();
        
        group4.addSoldier(new HorsemenProxy(100));
        group4.addSoldier(new HorsemenProxy(100));
        group4.addSoldier(new HorsemenProxy(100));
        
        group5.addSoldier(new InfantrymenProxy(100));
        group5.addSoldier(new InfantrymenProxy(100));
        group5.addSoldier(new InfantrymenProxy(100));
        
        group6.addSoldier(new InfantrymenProxy(100));
        group6.addSoldier(new HorsemenProxy(100));
        group6.addSubGroup(group4);
        group6.addSubGroup(group5);
      
        
        group3.addSword();
        group6.addShield();
        
        ArmyGroup f = group3;
        ArmyGroup c = group6;
        
        int ncoups = 0;
        boolean vc = true;
        boolean vf = true;

        for (; (vf = f.wardOff(c.hit())) && (vc = c.wardOff(f.hit())); ncoups++)
            ;

        System.out.println("Death of the " + (vf ? "Horsemen" : "Infantrymen")
                + " in " + ncoups + " shots");
        
        // Visitor    
        group3.accept(new visitorCountArmy());
        group3.accept(new visitorDisplayArmy());
       ;
    }
}