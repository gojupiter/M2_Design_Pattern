import java.util.ArrayList;
import java.util.List;

public class SoldierComposite implements Soldier {
    private List<SoldierProxy> soldiers = new ArrayList<>();
    private List<SoldierComposite> soldierComposites = new ArrayList<>();

    public void addSoldier(SoldierProxy soldier) {
        soldiers.add(soldier);
    }

    public void addSoldierComposite(SoldierComposite soldierComposite) {
        soldierComposites.add(soldierComposite);
    }

    public void addEquipment(Equipment equipment) {
        soldiers.forEach(s -> s.addEquipment(equipment));
        soldierComposites.forEach(s -> s.addEquipment(equipment));
    }

    public int size() {
        return soldiers.size() + soldierComposites.stream().mapToInt(SoldierComposite::size).sum();
    }

    @Override
    public int hit() {
        return soldiers.stream().mapToInt(Soldier::hit).sum()
                + soldierComposites.stream().mapToInt(SoldierComposite::hit).sum();
    }

    @Override
    public boolean wardOff(int force) {
        int f = force / size();
        return soldiers.stream().anyMatch(s -> s.wardOff(f))
                || soldierComposites.stream().anyMatch(s -> s.wardOff(f * s.size()));
    }

    @Override
    public int accept(SoldierVisitor visitor) {
        return soldiers.stream().mapToInt(s -> s.accept(visitor)).sum()
                + soldierComposites.stream().mapToInt(s -> s.accept(visitor)).sum();
    }
}
