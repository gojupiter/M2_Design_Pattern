
public class InfantrymenProxy implements Soldier{
	private Soldier soldier;
	private equipment sword = new equipment(0,10);
	private equipment shield = new equipment(0,10);
	
	public InfantrymenProxy(int vie) {
		soldier = new Infantrymen(vie);
	}
	@Override
	public int hit() {
		// TODO Auto-generated method stub
		if(sword.getDurability()==0) System.out.println("Infantrymen sword broken");
		int x = soldier.hit()+sword.getValue();
		sword.decreaseDurability();
		return x;
	}

	@Override
	public boolean wardOff(int force) {
		// TODO Auto-generated method stub
//		System.out.println("force infant proxy = "+ force);
		if(shield.getDurability()==0) System.out.println("Infantrymen shield broken");
		boolean x = soldier.wardOff(force-shield.getValue());
		if (force>0) shield.decreaseDurability();
		return x;
	}
	
	public void INeedMorePower(int val) {
		System.out.println("Infantrymen! I grant your sword ");
		sword.increaseValue(val);
		System.out.println("Your sword damage = " + sword.getValue());
	}
	
	public void INeedMoreDefense(int val) {
		System.out.println("Infantrymen! I grant your shield ");
		shield.increaseValue(val);
		System.out.println("Your shield defense = " + shield.getValue());
	}
}
