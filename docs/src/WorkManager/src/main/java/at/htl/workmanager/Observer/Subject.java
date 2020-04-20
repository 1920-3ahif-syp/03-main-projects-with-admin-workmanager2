package main.java.at.htl.workmanager.Observer;

import at.htl.workmanager.WorkPlan.WorkDay;
import at.htl.workmanager.Observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver( Observer observer);
    void notifyObservers(WorkDay p);
}
