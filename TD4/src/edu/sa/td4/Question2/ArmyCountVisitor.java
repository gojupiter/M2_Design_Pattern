package edu.sa.td4.Question2;

import java.util.List;

public class ArmyCountVisitor implements ArmyVisitor {

    private int numberHorsemens = 0;
    private int numberInfantrymen = 0;
    @Override
    public void visit(Group group) {
        System.out.println("Count the number member of group.");

        List<Soldier> soldiers = group.getListSoldiers();
        for(Soldier s : soldiers){
            s.accept(this);
        }

        List<Group> subGroups = group.getListSubGroups();
        for ( Group g : subGroups) {
            g.accept(this);
        }

        System.out.println("Number of horsemen in this group is: " + numberHorsemens);
        System.out.println("Number of infantrymen in this group is: " + numberInfantrymen);

    }

    @Override
    public void visit(ProxyHorsemen horsemen) {
        numberHorsemens++;
    }

    @Override
    public void visit(ProxyInfantrymen infantrymen) {
        numberInfantrymen++;
    }

    @Override
    public void visit(Horsemen horsemen) {
        numberHorsemens++;
    }

    @Override
    public void visit(Infantrymen infantrymen) {
       numberInfantrymen++;
    }
}
