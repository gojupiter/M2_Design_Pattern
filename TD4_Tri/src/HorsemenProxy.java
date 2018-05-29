
public class HorsemenProxy implements Soldier {
	private Soldier soldier;
	private equipment sword = new equipment(0,10);
	private equipment shield = new equipment(0,10);
	
	public HorsemenProxy(int vie) {
		soldier = new Horsemen(vie);
	}
	@Override
	public int hit() {
		// TODO Auto-generated method stub
		if(sword.getDurability()==0) System.out.println("Horsemen sword broken");
		int x = soldier.hit()+sword.getValue();
		sword.decreaseDurability();
		return x;
	}

	@Override
	public boolean wardOff(int force) {
		// TODO Auto-generated method stub
//		System.out.println("forcehorseproxy = "+ force);
		if(shield.getDurability()==0) System.out.println("Horsemen shield broken");
		boolean x = soldier.wardOff(force-shield.getValue());
		if (force>0) shield.decreaseDurability();
		return x;
	}
	
	public void INeedMorePower(int val) {
		System.out.println("Horsemen! I grant your sword ");
		sword.increaseValue(val);
		System.out.println("Your sword damage = " + sword.getValue());
	}
	
	public void INeedMoreDefense(int val) {
		System.out.println("Horsemen! I grant your shield ");
		shield.increaseValue(val);
		System.out.println("Your shield defense = " + shield.getValue());
	}
	
	public void accept(visitorInterface v) {
		v.visit(this);
	}
	
	public String toString() {
		return "Horsemen(proxy)";
	}
}
