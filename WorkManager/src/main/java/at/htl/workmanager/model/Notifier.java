package at.htl.workmanager.model;


import java.util.LinkedList;
import java.util.List;


public class Notifier implements Subject {

    private List<Observer> observers = new LinkedList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        if(!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers(WorkDay p) {
        for(Observer o : observers) {
            o.update(p);
        }
    }
}
