public class SoldierMemberVisitor implements SoldierVisitor {
    @Override
    public int visit(InfantrymenProxy infantrymen) {
        System.out.println("Infantry: " + infantrymen.getName());
        return 1;
    }

    @Override
    public int visit(HorsemenProxy horsemen) {
        System.out.println("Horsemen: " + horsemen.getName());
        return 1;
    }
}
