package at.htl.workmanager.Observer;

import at.htl.workmanager.WorkPlan.WorkDay;

public interface Subject {

    void registerObserver(Observer observer);
    void unregisterObserver( Observer observer);
    void notifyObservers(WorkDay p);
}
