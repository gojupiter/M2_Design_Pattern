package edu.sa.td4.Question2;

import java.util.List;

public class ProxyHorsemen extends ProxySoldier {

    private Horsemen realHorsemen;
    private Shield shield;
    public ProxyHorsemen(int vie) {
        super(vie);
    }

    @Override
    public int hit() {
        if(realHorsemen == null)
            realHorsemen = new Horsemen(vie);
        return realHorsemen.hit();
    }

    @Override
    public boolean wardOff(int force) {
        if(realHorsemen == null)
            realHorsemen = new Horsemen(vie);
        if(shield!=null && shield.getVie()>0){
            System.out.println("Shield help to decrease "+ shield.getForce() + " force from the attacker to the " + toString());
            shield.deteriorated();
            if(shield.getVie()==0){
                System.out.println("=========================================================");
                System.out.println("=========================================================");
                System.out.println("======================== WARNING ========================");
                System.out.println("=========================================================");
                System.out.println("=========================================================");
                System.out.println("Shield is deteriorated, from now on the " + toString() + " will fight without the shield");
            }

            return realHorsemen.wardOff((force - shield.getForce() > 0)? force - shield.getForce(): 0);
        }
        return realHorsemen.wardOff(force);
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
        System.out.println(toString() + " don't use sword");
        //do nothing since horsemen only have shield, not sword
        return;
    }

    @Override
    public String toString() {
        if(realHorsemen == null)
            realHorsemen = new Horsemen(vie);
        return realHorsemen.toString();
    }

    @Override
    public void accept(ArmyVisitor visitor) {
        visitor.visit(this);
    }
}
