package edu.sa.td4.Question1;

abstract public class Weapon {
    private int force;
    private int vie;
    public Weapon(int force, int vie){
        this.force = force;
        this.vie = vie;
    }

    public int getForce() {
        return force;
    }

    public int getVie() {
        return vie;
    }

    public void deteriorated(){
        this.vie--;
    }

    abstract public String toString();


}
