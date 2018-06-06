
public interface Soldier {
    public int hit();

    public boolean wardOff(int force);

    default int accept(SoldierVisitor visitor) {return 0;}
}
