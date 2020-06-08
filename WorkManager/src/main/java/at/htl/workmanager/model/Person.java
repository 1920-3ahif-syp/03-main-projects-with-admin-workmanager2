package at.htl.workmanager.model;

public class Person {

    private static long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;


    public Person(long id, String firstName, String lastName, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    protected long getId() {
        return this.id;
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

    @Override
    public String toString() {
        return "Person: ID: " + this.id + " Firstname: " + getFirstName() + " Lastname: " + getLastName();
    }

}
