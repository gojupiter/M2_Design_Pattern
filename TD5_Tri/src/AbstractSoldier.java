
abstract class AbstractSoldier implements Soldier {
    protected int vie;

    AbstractSoldier(int vie) {
        this.vie = vie;
    }

    public boolean wardOff(int force) {
//    	System.out.println("force abstract = "+ force);
    	if (force<0) force = 0; //to make sure if shield value is too high, the value wont be negative and thus increase the life (vie)
        vie = (vie > force) ? vie - force : 0;
        return vie > 0;
    }
}