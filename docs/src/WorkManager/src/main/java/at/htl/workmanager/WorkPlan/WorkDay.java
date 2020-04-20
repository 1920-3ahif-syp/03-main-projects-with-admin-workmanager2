package at.htl.workmanager.WorkPlan;

import at.htl.workmanager.Users.Person;

public class WorkDay {

    private Person employee;
    private double hours;
    private String dayName;

    public WorkDay(Person employee, double hours, String dayName) {
        this.employee = employee;
        this.hours = hours;
        this.dayName = dayName;
    }

    public double getHours() {
        return hours;
    }

    public Person getEmployee() {
        return this.employee;
    }
}
