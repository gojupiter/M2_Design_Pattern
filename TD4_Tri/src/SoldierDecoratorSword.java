
public class SoldierDecoratorSword extends SoldierDecorator{

	public SoldierDecoratorSword(Soldier sol) {
		super(sol);
		// TODO Auto-generated constructor stub
	}
	
	public int hit() {
		return super.hit()+6;
	}
}
