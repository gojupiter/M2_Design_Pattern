public interface SoldierSubject<E> {
    void register(SoldierObserver observer);

    void notifyObservers();

    E getUpdate(SoldierObserver observer);
}
