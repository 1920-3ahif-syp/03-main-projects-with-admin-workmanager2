package main.java.at.htl.workmanager.model;


public interface Subject {
    void registerObserver(Observer observer);
    void unregisterObserver( Observer observer);
    void notifyObservers(WorkDay p);
}
