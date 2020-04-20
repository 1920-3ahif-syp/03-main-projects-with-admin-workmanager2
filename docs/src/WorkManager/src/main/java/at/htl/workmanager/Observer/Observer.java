package main.java.at.htl.workmanager.Observer;

import at.htl.workmanager.WorkPlan.WorkDay;

public interface Observer {
    void update(WorkDay day);
}
