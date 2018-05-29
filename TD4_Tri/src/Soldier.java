
public interface Soldier {
    public int hit();

    public boolean wardOff(int force);
    
    public void accept(visitorInterface v);
}