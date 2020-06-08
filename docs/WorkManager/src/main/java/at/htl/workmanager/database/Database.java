package at.htl.workmanager.database;

import org.apache.derby.jdbc.ClientDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    static final String DATABASE = "db";
    static final String USERNAME = "app";
    static final String PASSWORD = "app";
    public static final String URL = "jdbc:derby://localhost:1527/" + DATABASE + ";username=" + USERNAME + ";password=" + PASSWORD; //+ ";create=true";


    public static DataSource getDataSource(){
        ClientDataSource dataSource = new ClientDataSource();
        dataSource.setDatabaseName(DATABASE);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

    public void createTableTest(){
        try {
            Connection conn = getDataSource().getConnection();
            conn.setAutoCommit(true);

            PreparedStatement ps = conn.prepareStatement("CREATE TABLE MEMBER (" +
                    "INT NOT NULL\n" +
                    "        CONSTRAINT MEMBER_PK PRIMARY KEY\n" +
                    "        GENERATED ALWAYS AS IDENTITY,," +
                    "m_s_id INT NOT NULL CONSTRAINT M_S_FK REFERENCES schedule(s_id),\n" +
                    "m_emp_id INT NOT NULL CONSTRAINT M_EMP_FK REFERENCES employee(emp_id),\n" +
                    "m_member_name VARCHAR(32)," +
                    "m_phone_number VARCHAR(11)" +
                    ")");
            ps.execute();

            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}