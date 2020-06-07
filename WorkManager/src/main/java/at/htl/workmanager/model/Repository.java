package at.htl.workmanager.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Repository {

    private static Repository instance;
    private Connection connection;
    private static final String USERNAME = "app";
    private static final String PASSWORD = "app";

    private Repository() {
    }

    public static Repository getInstance() {
        if(instance == null) {
            instance = new Repository();
        }

        return instance;
    }

    public void dropTables() {
        try {
            connection = DriverManager.getConnection("jdbc:derby:db;username=" + USERNAME + ";password=" + PASSWORD + ";");
            connection.setAutoCommit(true);

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void createTables() {
    }


}
