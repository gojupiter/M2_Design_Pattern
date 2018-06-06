import java.util.ArrayList;
import java.util.List;

public abstract class SoldierProxy implements Soldier, SoldierSubject<SoldierProxy> {
    protected String name;
    protected Soldier soldier;
    protected List<Equipment> equipments = new ArrayList<>();
    protected List<SoldierObserver> observers = new ArrayList<>();

    public SoldierProxy(String name) {
        this.name = name;
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    public boolean isDead() {
        return !soldier.wardOff(0);
    }

    @Override
    public int hit() {
        if (soldier == null) return 0;

        return soldier.hit() + equipments.stream().mapToInt(i -> i.damage()).sum();
    }

    @Override
    public boolean wardOff(int force) {
        if (soldier == null) return false;

        return soldier.wardOff(force - equipments.stream().mapToInt(i -> i.shield()).sum());
    }

    @Override
    public void register(SoldierObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update());
    }

    @Override
    public SoldierProxy getUpdate(SoldierObserver observer) {
        return this;
    }

    public String getName() {
        return name;
    }
}
