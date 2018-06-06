public abstract class AbstractEquipment implements Equipment {
    protected int deteriorated = 10;

    public boolean isDeteriorated() {
        return deteriorated-- == 0;
    }

    @Override
    public int shield() {
        return 0;
    }

    @Override
    public int damage() {
        return 0;
    }
}
