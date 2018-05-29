
public interface visitorInterface {
	public void visit(ArmyGroup ag);
	public void visit(HorsemenProxy s);
	public void visit(InfantrymenProxy s);
	public void visit(Infantrymen s);
	public void visit(Horsemen s);
	public void visit(SoldierDecorator s);
}
