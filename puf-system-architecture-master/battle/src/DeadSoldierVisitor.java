public class DeadSoldierVisitor implements SoldierVisitor {
    @Override
    public int visit(InfantrymenProxy infantrymen) {
        if (infantrymen.isDead()) {

            return 1;
        }
        return 0;
    }

    @Override
    public int visit(HorsemenProxy horsemen) {
        if (horsemen.isDead()) {

            return 1;
        }
        return 0;
    }
}
