package edu.sa.td4.Question2;

public interface Soldier {
    public int hit();

    public boolean wardOff(int force);

    public String toString();

    public void accept(ArmyVisitor visitor);
}