package at.htl.workmanager.model;

import at.htl.workmanager.database.SqlRunner;
import at.htl.workmanager.database.SqlScript;

import java.sql.*;

public class ScheduleRepository {

    private static final String TABLE_SCHEDULE = "SCHEDULE";
    private static ScheduleRepository instance;
    private Connection connection;
    private static final String USERNAME = "app";
    private static final String PASSWORD = "app";
    private static final String CONNECTION_STRING = "jdbc:derby:db;username=" + USERNAME + ";password=" + PASSWORD + ";";

    private ScheduleRepository() {
    }

    public static ScheduleRepository getInstance() {
        if(instance == null) {
            instance = new ScheduleRepository();
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

    public Schedule findById(int id) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "SELECT s_id,s_start_time,s_end_time,s_calendar_week FROM SCHEDULE WHERE s_id = " + id
            );

            ResultSet set = prepStatement.executeQuery();
            Schedule sd = null;

            while(set.next()) {
                sd = new Schedule(set.getLong("S_ID"), set.getTime("S_START_TIME"), set.getTime("S_END_TIME"), set.getShort("S_CALENDAR_WEEK"));
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

    public void insertSchedule(long id, Time startTime, Time endTime, short calendarWeek) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "INSERT INTO " + TABLE_SCHEDULE + " (S_ID,S_START_TIME,S_END_TIME,S_CALENDAR_WEEK) VALUES(?,?,?,?)"
            );

            prepStatement.setLong(1, id);
            prepStatement.setTime(2, startTime);
            prepStatement.setTime(3, endTime);
            prepStatement.setShort(4, calendarWeek);

            prepStatement.executeUpdate();
            connection.close();
            prepStatement.close();
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteScheduleById(long id) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "DELETE FROM " + TABLE_SCHEDULE + " WHERE S_ID = ?"
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
    public void updateSchedule(Schedule sd) {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
            connection.setAutoCommit(true);

            PreparedStatement prepStatement = connection.prepareStatement(
                    "UPDATE SCHEDULE SET S_START_TIME = ?, S_END_TIME = ?, S_CALENDAR_WEEK = ?"
            );

            prepStatement.setTime(1, sd.getStartTime());
            prepStatement.setTime(2, sd.getEndTime());
            prepStatement.setShort(3, sd.getCalendarWeek());

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
            ResultSet set = dbm.getTables(null, null, TABLE_SCHEDULE, null);

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
