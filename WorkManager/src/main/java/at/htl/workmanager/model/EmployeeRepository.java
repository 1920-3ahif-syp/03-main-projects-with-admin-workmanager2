package at.htl.workmanager.model;

import at.htl.workmanager.database.SqlRunner;
import at.htl.workmanager.database.SqlScript;

import java.sql.*;

public class EmployeeRepository {

    private static final String TABLE_EMPLOYEE = "EMPLOYEE";
    private static EmployeeRepository instance;
    private Connection connection;
    private static final String USERNAME = "app";
    private static final String PASSWORD = "app";
    private static final String CONNECTION_STRING = "jdbc:derby:db;username=" + USERNAME + ";password=" + PASSWORD + ";";

    private EmployeeRepository() {
    }

    public static EmployeeRepository getInstance() {
        if(instance == null) {
            instance = new EmployeeRepository();
        }

        return instance;
    }

    public void dropTables() {
        SqlRunner.runScript(SqlScript.DROP);
    }

    public void createTables() {
        dropTables();
        SqlRunner.runScript(SqlScript.CREATE);
    }

    public Employee findById(int id) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "SELECT emp_id,emp_firstname,emp_lastname FROM EMPLOYEE WHERE emp_id = " + id
            );

            ResultSet set = prepStatement.executeQuery();
            Employee emp = null;

            while(set.next()) {
                emp = new Employee(set.getLong("EMP_ID"), set.getString("EMP_FIRSTNAME"), set.getString("EMP_LASTNAME"), null, null);
                break;
            }

            connection.close();
            prepStatement.close();
            set.close();

            return emp;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void insertEmployee(long id, String firstname, String lastname, String phoneNumber) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "INSERT INTO " + TABLE_EMPLOYEE + " (EMP_ID,EMP_FIRSTNAME,EMP_LASTNAME,EMP_PHONE_NUMBER) VALUES(?,?,?,?)"
            );

            prepStatement.setLong(1, id);
            prepStatement.setString(2, firstname);
            prepStatement.setString(3, lastname);
            prepStatement.setString(4, phoneNumber);

            prepStatement.executeUpdate();
            connection.close();
            prepStatement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteEmployeeById(long id) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "DELETE FROM " + TABLE_EMPLOYEE + " WHERE EMP_ID = ?"
            );

            prepStatement.setLong(1, id);
            prepStatement.executeUpdate();
            connection.close();
            prepStatement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateEmployee(Employee emp) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "UPDATE EMPLOYEE SET EMP_FIRSTNAME = ?, EMP_LASTNAME = ?, EMP_PHONE_NUMBER = ?"
            );

            prepStatement.setString(1, emp.getFirstName());
            prepStatement.setString(2, emp.getLastName());
            prepStatement.setString(3, null);

            prepStatement.executeUpdate();
            prepStatement.close();
            connection.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean tableExists() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet set = dbm.getTables(null, null, TABLE_EMPLOYEE, null);

            if(set.next()) {
                return true;
            }

            connection.close();
            set.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
