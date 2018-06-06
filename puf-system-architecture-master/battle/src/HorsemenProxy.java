public class HorsemenProxy extends SoldierProxy {
    public HorsemenProxy(String name, int vie) {
        super(name);
        soldier = new Horsemen(vie);
    }

    @Override
    public int accept(SoldierVisitor visitor) {
        return visitor.visit(this);
    }
}
