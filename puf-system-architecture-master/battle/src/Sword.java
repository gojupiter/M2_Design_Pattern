public class Sword extends AbstractEquipment {
    @Override
    public int damage() {
        return isDeteriorated() ? 0 :1;
    }
}
