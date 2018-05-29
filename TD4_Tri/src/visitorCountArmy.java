import java.util.List;

public class visitorCountArmy implements visitorInterface {
	private int nbInfantry=0;
	private int nbHorsemen=0;
	@Override
	public void visit(ArmyGroup ag) {
		// TODO Auto-generated method stub
		System.out.println(">>> Visitor Design Pattern : Count infantry and horsemen in group of soldiers <<<");
		List<Soldier> listsoldier = ag.getListSoldiers();
		List<ArmyGroup> listsubgroup = ag.getListSubGroups();
		
		for (Soldier s : listsoldier) {
			s.accept(this);
		}
		for (ArmyGroup g : listsubgroup) {
			g.accept(this);
		}
		
		System.out.println("Infantrymen : " + nbInfantry);
		System.out.println("Horsemen : " + nbHorsemen);
	}

	@Override
	public void visit(HorsemenProxy s) {
		// TODO Auto-generated method stub
		nbHorsemen++;
	}

	@Override
	public void visit(InfantrymenProxy s) {
		// TODO Auto-generated method stub
		nbInfantry++;
	}

	@Override
	public void visit(Infantrymen s) {
		// TODO Auto-generated method stub
		nbInfantry++;
	}

	@Override
	public void visit(Horsemen s) {
		// TODO Auto-generated method stub
		nbHorsemen++;
	}

	@Override
	public void visit(SoldierDecorator s) {
		// TODO Auto-generated method stub
		if (Infantrymen.class.isInstance(s) || InfantrymenProxy.class.isInstance(s)) nbInfantry++;
		else nbHorsemen++;
	}

}
