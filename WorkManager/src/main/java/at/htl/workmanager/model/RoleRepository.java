package at.htl.workmanager.model;

import at.htl.workmanager.database.SqlRunner;
import at.htl.workmanager.database.SqlScript;

import java.sql.*;

public class RoleRepository {

    private static final String TABLE_ROLE = "ROLE";
    private static RoleRepository instance;
    private Connection connection;
    private static final String USERNAME = "app";
    private static final String PASSWORD = "app";
    private static final String CONNECTION_STRING = "jdbc:derby:db;username=" + USERNAME + ";password=" + PASSWORD + ";";

    private RoleRepository() {
    }

    public static RoleRepository getInstance() {
        if(instance == null) {
            instance = new RoleRepository();
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

    public Role findById(int id) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "SELECT r_id, r_rolename FROM ROLE WHERE r_id = " + id
            );

            ResultSet set = prepStatement.executeQuery();
            Role sd = null;

            while(set.next()) {
                sd = new Role(set.getShort("R_ID"), RoleState.valueOf(set.getString("R_ROLENAME")));
                break;
            }

            connection.close();
            prepStatement.close();
            set.close();

            return sd;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void insertRole(long id, RoleState roleName) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "INSERT INTO " + TABLE_ROLE + " (R_ID,R_ROLENAME) VALUES(?,?)"
            );

            prepStatement.setLong(1, id);
            prepStatement.setString(2, roleName.toString());

            prepStatement.executeUpdate();
            connection.close();
            prepStatement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteRoleById(long id) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "DELETE FROM " + TABLE_ROLE + " WHERE R_ID = ?"
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
    public void updateRole(Role roleName) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "UPDATE ROLE SET R_ROLENAME = ?"
            );

            prepStatement.setString(1, roleName.toString());

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
            ResultSet set = dbm.getTables(null, null, TABLE_ROLE, null);

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
