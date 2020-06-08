package at.htl.workmanager.model;

import at.htl.workmanager.model.Person;

public class Manager extends Person {

    private static long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public Manager(long id, String firstName, String lastName, String userName, String password) {
        super(id, firstName, lastName, userName, password);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getUserName() {
        return this.userName;
    }

    private String password() {
        return this.password;
    }

    @Override
    public String toString() {
        return "Manager: ID: " + this.id + " Firstname: " + getFirstName() + " Lastname: " + getLastName();
    }
}
