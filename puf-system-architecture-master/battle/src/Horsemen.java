

public class Horsemen extends AbstractSoldier {
    private static final int FORCE_HORSEMEN = 2;

    public Horsemen(int vie) {
        super(vie);
    }

    public int hit() {
        return FORCE_HORSEMEN;
    }
}