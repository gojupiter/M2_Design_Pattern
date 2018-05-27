package edu.sa.td4.Question2;

import java.util.List;

public class ArmyDisplayVisitor implements ArmyVisitor {

    @Override
    public void visit(Group g) {
        System.out.println("Displaying member of group.");
//        System.out.println(g.toString());

        List<Soldier> soldiers = g.getListSoldiers();
        System.out.println("------------------------------");
        System.out.println("Displaying solo soldier of group. (Soldier not in a subgroup)");
        for(Soldier s : soldiers){
            s.accept(this);
        }
        System.out.println("------------------------------");
        List<Group> subGroups = g.getListSubGroups();
        for ( Group s : subGroups) {
            System.out.println("------------------------------");
            System.out.println("Displaying member of subgroup number " + (subGroups.indexOf(s) +1));
            s.accept(this);
            System.out.println("------------------------------");
        }


    }

    @Override
    public void visit(ProxyHorsemen horsemen) {
        System.out.println(horsemen.toString());
    }

    @Override
    public void visit(ProxyInfantrymen infantrymen) {
        System.out.println(infantrymen.toString());
    }

    @Override
    public void visit(Horsemen horsemen) {
        System.out.println(horsemen.toString());
    }

    @Override
    public void visit(Infantrymen infantrymen) {
        System.out.println(infantrymen.toString());
    }
}
