package at.htl.workmanager.model.observer;


import at.htl.workmanager.model.workPlan.WorkDay;

public interface Observer {
    public void update(WorkDay day);
}
