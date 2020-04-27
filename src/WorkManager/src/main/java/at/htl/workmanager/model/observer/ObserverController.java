package at.htl.workmanager.model.observer;


import at.htl.workmanager.model.workPlan.WorkDay;

public class ObserverController implements Observer {
    @Override
    public void update(WorkDay day) {
        System.out.println("Some Workplan has been changed!");
    }
}
