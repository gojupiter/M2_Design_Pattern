package edu.sa.td4.Question1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Group {
    private List<Soldier> listSoldiers;
    private List<Group> listSubGroups;

    public Group(){
        listSoldiers = new ArrayList<Soldier>();
        listSubGroups = new ArrayList<Group>();
    }

    public void addSubGroup(Group newSubGroup){
        listSubGroups.add(newSubGroup);
    }

    public void addSoldier(Soldier newSoldier){
        listSoldiers.add(newSoldier);
    }

    public List<Soldier> getListSoldiers() {
        return listSoldiers;
    }

    public List<Group> getListSubGroups() {
        return listSubGroups;
    }

    public int hit(){

        int total=0;
        for(Soldier s : listSoldiers){
            total += s.hit();
        }

        for(Group g : listSubGroups){
            total += g.hit();
        }
        System.out.println( toString() + " attack with " + total + " force" );
        return total;
    }

    public boolean wardOff(int force){
        System.out.println( toString() + " receive attack with " + force + " force" );
        int each_receive_hit = (int) Math.floor(force / getTotalSoldier());
        System.out.println("Each receive hit: " + each_receive_hit );
        for(int i =0; i < listSubGroups.size(); i++){
            Group g = listSubGroups.get(i);
            int group_receive_hit = each_receive_hit * g.getTotalSoldier();
            if(!g.wardOff(group_receive_hit)){
                i--;
                listSubGroups.remove(g);
            }
        }
//        for(Group g : listSubGroups){
//            int group_receive_hit = each_receive_hit * g.getTotalSoldier();
//            if(!g.wardOff(group_receive_hit)){
//                listSubGroups.remove(g);
//            }
//        }

        for(int i =0; i < listSoldiers.size(); i++){
            Soldier s = listSoldiers.get(i);
            if(!s.wardOff(each_receive_hit)){
                i--;
                listSoldiers.remove(s);
            }
        }
//        for (Soldier s : listSoldiers){
//            if(!s.wardOff(each_receive_hit)){
//                listSoldiers.remove(s);
//            }
//        }

        return (listSubGroups.size() > 0 || listSoldiers.size() > 0);
    }

    public int getTotalSoldier(){
        int total = 0;
        for(Group g : listSubGroups){
            total += g.getTotalSoldier();
        }
        total += listSoldiers.size();

        return total;
    }

    public String toString(){
        String sb = "Group with " + listSubGroups.size() + " groups and " + listSoldiers.size() + " soldiers and " + getTotalSoldier() + " soldiers in total";
        return sb;
    }

    public void addSword(){
        for(Group g : listSubGroups)
            g.addSword();

        for(Soldier s : listSoldiers){
            if(ProxySoldier.class.isInstance(s)){
                ((ProxySoldier) s).addSword();
            }
        }
    }

    public void addShield(){
        for(Group g : listSubGroups)
            g.addShield();

        for(Soldier s : listSoldiers)
            if(ProxySoldier.class.isInstance(s)){
                ((ProxySoldier) s).addShield();
            }
    }
}
