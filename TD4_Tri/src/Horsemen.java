

public class Horsemen extends AbstractSoldier {
    private static final int FORCE_HORSEMEN = 1;

    public Horsemen(int vie) {
        super(vie);
    }

    public int hit() {
        return FORCE_HORSEMEN;
    }
    
    public void accept(visitorInterface v) {
		v.visit(this);
	}
    
	public String toString() {
		return "Horsemen";
	}
	
}