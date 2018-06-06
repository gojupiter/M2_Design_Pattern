public class SoldierDecorator implements Soldier {
    private Soldier soldier;

    public SoldierDecorator(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public int hit() {
        return soldier.hit();
    }

    @Override
    public boolean wardOff(int force) {
        return soldier.wardOff(force);
    }
}
