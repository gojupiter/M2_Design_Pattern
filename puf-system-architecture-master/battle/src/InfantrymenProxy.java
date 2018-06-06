public class InfantrymenProxy extends SoldierProxy {
    public InfantrymenProxy(String name, int vie) {
        super(name);
        soldier = new Infantrymen(vie);
    }

    @Override
    public int accept(SoldierVisitor visitor) {
        return visitor.visit(this);
    }
}
