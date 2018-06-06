import java.util.ArrayList;
import java.util.List;

public class SoldierSubscriber implements SoldierObserver {
    private static SoldierSubscriber instance = null;
    private List<SoldierSubject<SoldierProxy>> subjects = new ArrayList<>();

    private SoldierSubscriber() {
    }

    public static SoldierSubscriber getInstance() {
        if (instance == null) {
            instance = new SoldierSubscriber();
        }
        return instance;
    }

    @Override
    public void update() {
        subjects.forEach(subject -> {
            SoldierProxy soldier = subject.getUpdate(this);
            System.out.println("Soldier " + soldier.getName() + (soldier.isDead() ? " has dead" : " still alive"));
        });
    }

    @Override
    public void addSubject(SoldierSubject subject) {
        subjects.add(subject);
    }
}
