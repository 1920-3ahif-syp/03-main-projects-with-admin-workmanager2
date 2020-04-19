package main.java.at.htl.workmanager.Users;

public class Boss  extends at.htl.workmanager.Users.Person {

    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public Boss(String firstName, String lastName, String userName, String password) {
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
