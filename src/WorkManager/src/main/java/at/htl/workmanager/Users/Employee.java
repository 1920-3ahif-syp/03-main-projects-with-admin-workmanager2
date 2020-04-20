package main.java.at.htl.workmanager.Users;

import main.java.at.htl.workmanager.Observer.Observer;
import main.java.at.htl.workmanager.WorkPlan.WorkDay;

public class Employee implements Observer {
    public String getLastName() {
        return lastName;
    }

    public double getWeekHours() {
        return weekHours;
    }

    public double getOvertime() {
        return overtime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWeekHours(double weekHours) {
        this.weekHours = weekHours;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    private String firstName;
    private String lastName;
    private double weekHours;
    private double overtime;
    private double worked;

    public Employee(String firstName, String lastName, double weekHours) {
        setFirstName(firstName);
        setLastName(lastName);
        setWeekHours(weekHours);
    }

    private void calculateOvertime (){
        if (worked > weekHours){
            setOvertime(worked - getWeekHours());
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void update(WorkDay day) {
        if(day.getEmployee().getFullName().equals(getFullName())) {
            this.worked = day.getHours();
        }
    }
}
