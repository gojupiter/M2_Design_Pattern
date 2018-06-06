public class Shield extends AbstractEquipment {
    @Override
    public int shield() {
        return isDeteriorated() ? 0 : 1;
    }
}
