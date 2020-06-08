package at.htl.workmanager.model;

import at.htl.workmanager.database.SqlRunner;
import at.htl.workmanager.database.SqlScript;

import java.sql.*;

public class MemberRepository {

    private static final String TABLE_MEMBER = "MEMBER";
    private static MemberRepository instance;
    private Connection connection;
    private static final String USERNAME = "app";
    private static final String PASSWORD = "app";
    private static final String CONNECTION_STRING = "jdbc:derby:db;username=" + USERNAME + ";password=" + PASSWORD + ";";

    private MemberRepository() {
    }

    public static MemberRepository getInstance() {
        if(instance == null) {
            instance = new MemberRepository();
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

    public Manager findById(int id) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "SELECT m_id,m_member_firstname,m_member_lastname FROM EMPLOYEE WHERE emp_id = " + id
            );

            ResultSet set = prepStatement.executeQuery();
            Manager mg = null;

            while(set.next()) {
                mg = new Manager(set.getLong("M_ID"), set.getString("M_MEMBER_FIRSTNAME"), set.getString("M_MEMBER_LASTNAME"), null, null);
                break;
            }

            connection.close();
            prepStatement.close();
            set.close();

            return mg;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void insertMember(long id, String firstname, String lastname, String phoneNumber) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "INSERT INTO " + TABLE_MEMBER + " (M_ID,M_MEMBER_FIRSTNAME,M_MEMBER_LASTNAME,M_PHONE_NUMBER) VALUES(?,?,?,?)"
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

    public void deleteMemberById(long id) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "DELETE FROM " + TABLE_MEMBER + " WHERE M_ID = ?"
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
    public void updateEmployee(Manager mg) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "UPDATE MEMBER SET M_MEMBER_FIRSTNAME = ?, M_MEMBER_LASTNAME = ?, M_PHONE_NUMBER = ?"
            );

            prepStatement.setString(1, mg.getFirstName());
            prepStatement.setString(2, mg.getLastName());
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
            ResultSet set = dbm.getTables(null, null, TABLE_MEMBER, null);

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
