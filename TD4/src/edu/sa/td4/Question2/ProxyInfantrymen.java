package edu.sa.td4.Question2;

public class ProxyInfantrymen extends ProxySoldier  {

    private Infantrymen realInfantrymen;
    private Weapon sword;
    private Weapon shield;

    public ProxyInfantrymen(int vie) {
        super(vie);
    }

    @Override
    public int hit() {
        if(realInfantrymen==null)
            realInfantrymen = new Infantrymen(vie);
        if(sword!= null && sword.getVie()>0){
            System.out.println("Sword help to increase "+ sword.getForce() + " force to the " + toString());
            sword.deteriorated();
            if(sword.getVie()==0){
                System.out.println("=========================================================");
                System.out.println("=========================================================");
                System.out.println("======================== WARNING ========================");
                System.out.println("=========================================================");
                System.out.println("=========================================================");
                System.out.println("Sword is deteriorated, from now on the " + toString() + " will fight without the sword");
            }

            return realInfantrymen.hit() + sword.getForce();
        }
        return realInfantrymen.hit();
    }

    @Override
    public boolean wardOff(int force) {
        if(realInfantrymen==null)
            realInfantrymen = new Infantrymen(vie);

        if(shield!=null && shield.getVie() > 0){
            System.out.println("Shield help to decrease "+ shield.getForce() + " force from the attacker to the " + toString());
            shield.deteriorated();
            if(shield.getVie()==0) {
                System.out.println("=========================================================");
                System.out.println("=========================================================");
                System.out.println("======================== WARNING ========================");
                System.out.println("=========================================================");
                System.out.println("=========================================================");
                System.out.println("Shield is deteriorated, from now on the " + toString() + " will fight without the shield");
            }
            return realInfantrymen.wardOff((force - shield.getForce() > 0)? force - shield.getForce(): 0);
        }
        return realInfantrymen.wardOff(force);
    }

    @Override
    public void addShield() {
        if(this.shield==null)
            this.shield = new Shield();
        else
            System.out.println(toString() + " already have a shield, can't add another one");
    }

    @Override
    public void addSword() {
        if(this.sword==null)
            this.sword = new Sword();
        else
            System.out.println(toString() + " already have a sword, can't add another one");
    }

    @Override
    public String toString() {
        if(realInfantrymen == null)
            realInfantrymen = new Infantrymen(vie);
        return realInfantrymen.toString();
    }

    @Override
    public void accept(ArmyVisitor visitor) {
        visitor.visit(this);
    }
}
