package main.java.at.htl.workmanager.Observer;

import main.java.at.htl.workmanager.WorkPlan.WorkDay;

public interface Observer {
    public void update(WorkDay day);
}
