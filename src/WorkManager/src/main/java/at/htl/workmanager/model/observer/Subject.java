package at.htl.workmanager.model.observer;


import at.htl.workmanager.model.workPlan.WorkDay;

public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver( Observer observer);
    void notifyObservers(WorkDay p);
}
