package at.htl.workmanager.model;

import at.htl.workmanager.model.Person;

public class Manager extends Person {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public Manager(String firstName, String lastName, String userName, String password) {
        super(firstName, lastName, userName, password);
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
}
