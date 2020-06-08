import at.htl.workmanager.database.Database;
import at.htl.workmanager.database.SqlRunner;
import at.htl.workmanager.database.SqlScript;
import at.htl.workmanager.model.Employee;
import at.htl.workmanager.model.Repository;
import org.junit.jupiter.api.BeforeEach;
import javax.sql.DataSource;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.*;

import javax.sql.DataSource;

import java.sql.*;
import java.util.List;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Employee {

    private static final String TABLE_NAME = "EMPLOYEE";
    private Repository repo;
    private DataSource dataSource = Database.getDataSource();
    private Connection connection;

    @BeforeEach
    void setup() {
        SqlRunner.dropTablesAndCreateEmptyTables();
        repo = Repository.getInstance();
    }

    @Test
    @Order(100)
    public void insertExampleData() {
        SqlRunner.runScript(SqlScript.INSERT);


    }

    @Test
    @Order(200)
    public void findByIdOK() {
        Employee newEmp;

    }

    @Test
    @Order(300)
    public void dropTables() {
        repo.dropTables();
        org.assertj.core.api.Assertions.assertThat(repo.tableExists(TABLE_NAME) == true);
    }

}
