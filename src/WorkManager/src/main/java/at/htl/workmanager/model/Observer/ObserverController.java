package main.java.at.htl.workmanager.Observer;

import at.htl.workmanager.WorkPlan.WorkDay;
import at.htl.workmanager.Observer.Observer;

public class ObserverController implements Observer {
    @Override
    public void update(WorkDay day) {
        System.out.println("Some Workplan has been changed!");
    }
}