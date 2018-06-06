public class EquipmentSoldierDecorator extends SoldierDecorator {
    private Equipment equipment;

    public EquipmentSoldierDecorator(Soldier soldier, Equipment equipment) {
        super(soldier);
        this.equipment = equipment;
    }

    @Override
    public int hit() {
        return super.hit() + equipment.damage();
    }

    @Override
    public boolean wardOff(int force) {
        return super.wardOff(force - equipment.shield());
    }
}
