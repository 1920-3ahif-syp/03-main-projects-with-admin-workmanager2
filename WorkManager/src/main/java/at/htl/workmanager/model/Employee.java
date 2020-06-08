package at.htl.workmanager.model;

public class Employee extends Person{

    private static long id;
    private String firstName;
    private String lastName;

    public Employee(long id, String firstName, String lastName, String username, String password) {
        super(id, firstName, lastName, username, password);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Employee: ID: " + this.id + " Firstname: " + getFirstName() + " Lastname: " + getLastName();
    }

}
