
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArmyGroup {
    private List<Soldier> listSoldiers;
    private List<ArmyGroup> listSubGroups;

    public ArmyGroup(){
        listSoldiers = new ArrayList<Soldier>();
        listSubGroups = new ArrayList<ArmyGroup>();
    }

    public void addSubGroup(ArmyGroup newSubGroup){
        listSubGroups.add(newSubGroup);
    }

    public void addSoldier(Soldier newSoldier){
        listSoldiers.add(newSoldier);
    }

    public List<Soldier> getListSoldiers() {
        return listSoldiers;
    }

    public List<ArmyGroup> getListSubGroups() {
        return listSubGroups;
    }

    public int hit(){

        int damage=0;
        for(Soldier s : listSoldiers){
            damage += s.hit();
        }

        for(ArmyGroup ag : listSubGroups){
            damage += ag.hit();
        }
        System.out.println( toString() + " Damage dealt : " + damage + " force" );
        return damage;
    }

    public boolean wardOff(int force){
        System.out.println( toString() + " Damage taken : " + force + " force" );
        int damage_per_soldier = (int) Math.floor(force / getTotalSoldier());
        System.out.println("Each soldier is hit by : " + damage_per_soldier );
        for(int i =0; i < listSubGroups.size(); i++){
        	ArmyGroup g = listSubGroups.get(i);
            int group_receive_hit = damage_per_soldier * g.getTotalSoldier();
            if(!g.wardOff(group_receive_hit)){
                i--;
                listSubGroups.remove(g);
            }
        }


        for(int i =0; i < listSoldiers.size(); i++){
            Soldier s = listSoldiers.get(i);
            if(!s.wardOff(damage_per_soldier)){
                i--;
                listSoldiers.remove(s);
            }
        }


        return (listSubGroups.size() > 0 || listSoldiers.size() > 0);
    }

    public int getTotalSoldier(){
        int total = 0;
        for(ArmyGroup ag : listSubGroups){
            total += ag.getTotalSoldier();
        }
        total += listSoldiers.size();

        return total;
    }

    public String toString(){
        return "Army : " + listSubGroups.size() + " subgroups, " + listSoldiers.size() + " soldiers (not in subgroup). Total : " + getTotalSoldier();
    }

    public void addSword(){
        for(ArmyGroup ag : listSubGroups)
            ag.addSword();

        for(Soldier s : listSoldiers){
        	if(HorsemenProxy.class.isInstance(s)){
                ((HorsemenProxy) s).INeedMorePower(5);
            }
        	if(InfantrymenProxy.class.isInstance(s)){
                ((InfantrymenProxy) s).INeedMorePower(5);
            }
        }
    }

    public void addShield(){
        for(ArmyGroup ag : listSubGroups)
            ag.addShield();

        for(Soldier s : listSoldiers) {
            if(HorsemenProxy.class.isInstance(s)){
                ((HorsemenProxy) s).INeedMoreDefense(5);
            }
            if(InfantrymenProxy.class.isInstance(s)){
            	((InfantrymenProxy) s).INeedMoreDefense(5);
            }
        }
    }
    
    public void accept(visitorInterface v) {
		v.visit(this);
	}
}
