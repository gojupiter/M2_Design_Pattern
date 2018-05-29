import java.util.List;

public class visitorDisplayArmy implements visitorInterface {

	@Override
	public void visit(ArmyGroup ag) {
		System.out.println(">>> Visitor Design Pattern : Display group of soldiers <<<");
		List<Soldier> listsoldier = ag.getListSoldiers();
		List<ArmyGroup> listsubgroup = ag.getListSubGroups();
		
		for (Soldier s : listsoldier) {
			s.accept(this);
		}
		for (ArmyGroup g : listsubgroup) {
			g.accept(this);
		}
	}

	@Override
	public void visit(HorsemenProxy s) {
		// TODO Auto-generated method stub;
		System.out.println(s.toString());
	}

	@Override
	public void visit(InfantrymenProxy s) {
		// TODO Auto-generated method stub
		System.out.println(s.toString());
	}

	@Override
	public void visit(Infantrymen s) {
		// TODO Auto-generated method stub
		System.out.println(s.toString());
	}

	@Override
	public void visit(Horsemen s) {
		// TODO Auto-generated method stub
		System.out.println(s.toString());
	}

	@Override
	public void visit(SoldierDecorator s) {
		// TODO Auto-generated method stub
		System.out.println(s.toString());
	}



}
