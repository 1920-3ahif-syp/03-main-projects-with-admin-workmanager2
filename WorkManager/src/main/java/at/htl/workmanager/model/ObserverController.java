package at.htl.workmanager.model;


public class ObserverController implements Observer {
    @Override
    public void update(WorkDay day) {
        System.out.println("Some Workplan has been changed!");
    }
}
