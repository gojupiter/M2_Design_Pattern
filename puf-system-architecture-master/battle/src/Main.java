

public class Main {

    public static void main(String[] args) {
        SoldierObserver observer = SoldierSubscriber.getInstance();

        Equipment shield = new Shield();
        Equipment sword = new Sword();

        SoldierComposite group1 = new SoldierComposite();
        HorsemenProxy phong = new HorsemenProxy("Phong", 100);
        observer.addSubject(phong);
        group1.addSoldier(phong);

        InfantrymenProxy huy = new InfantrymenProxy("Huy", 50);
        observer.addSubject(huy);
        group1.addSoldier(huy);

        group1.addEquipment(shield);
        group1.addEquipment(sword);

        SoldierComposite army1 = new SoldierComposite();
        InfantrymenProxy hung = new InfantrymenProxy("Hung", 50);
        observer.addSubject(hung);
        army1.addSoldier(hung);

        army1.addSoldierComposite(group1);

        SoldierVisitor visitor = new SoldierMemberVisitor();
        System.out.println("[Total] " + army1.accept(visitor) + " soldiers.");
        System.out.println("Battle with");

        SoldierComposite group2 = new SoldierComposite();
        HorsemenProxy tam = new HorsemenProxy("Tam", 100);
        observer.addSubject(tam);
        group2.addSoldier(tam);

        InfantrymenProxy trang = new InfantrymenProxy("Trang", 50);
        observer.addSubject(trang);
        group2.addSoldier(trang);

        group2.addEquipment(shield);
        group2.addEquipment(sword);

        SoldierComposite army2 = new SoldierComposite();
        army2.addSoldierComposite(group2);

        System.out.println("[Total] " + army2.accept(visitor) + " soldiers.");

        int ncoups = 0;
        boolean vc = true;
        boolean vf = true;

        for (; (vf = army1.wardOff(army2.hit())) && (vc = army2.wardOff(army1.hit())); ncoups++) ;

        System.out.println("Death of the " + (vf ? "Army 2" : "Army 1")
                + " in " + ncoups + " shots");

        observer.update();
    }
}