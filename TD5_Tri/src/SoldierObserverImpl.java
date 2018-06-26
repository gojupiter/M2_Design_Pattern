import java.util.ArrayList;
import java.util.List;
public class SoldierObserverImpl implements SoldierObserver{
	    private static SoldierObserverImpl instance = null;
	    private List<SoldierSubject<Soldier>> subjects = new ArrayList<>();

	    private SoldierObserverImpl() {
	    }

	    public static SoldierObserverImpl getInstance() {
	        if (instance == null) {
	            instance = new SoldierObserverImpl();
	        }
	        return instance;
	    }

	    @Override
	    public void update() {
	        subjects.forEach(subject -> {
	            System.out.println("Soldier updated");
	        });
	    }

	    @Override
	    public void addSubject(SoldierSubject subject) {
	        subjects.add(subject);
	    }
	
}
