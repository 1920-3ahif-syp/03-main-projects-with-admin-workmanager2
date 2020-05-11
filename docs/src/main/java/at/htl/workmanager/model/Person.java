package at.htl.workmanager.model;

import java.util.Observer;

public class Person {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;


    public Person(String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    protected String getUserName() {
        return this.userName;
    }

    protected String getFirstName() {
        return this.firstName;
    }

    protected String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    private void changePassword(String newPassword) {
        //In-Progress!
    }

}
