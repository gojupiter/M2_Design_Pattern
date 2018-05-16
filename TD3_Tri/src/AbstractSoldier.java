
abstract class AbstractSoldier implements Soldier {
    protected int vie;

    AbstractSoldier(int vie) {
        this.vie = vie;
    }

    public boolean wardOff(int force) {
        vie = (vie > force) ? vie - force : 0;
        return vie > 0;
    }
    
    public int get_vie() {
    	return vie;
    }
}