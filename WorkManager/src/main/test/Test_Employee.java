import at.htl.workmanager.database.Database;
import at.htl.workmanager.database.SqlRunner;
import at.htl.workmanager.database.SqlScript;
import at.htl.workmanager.model.Employee;
import at.htl.workmanager.model.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import javax.sql.DataSource;

import org.junit.jupiter.api.*;

import java.sql.*;

import static org.assertj.db.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;
import static org.junit.jupiter.api.Assertions.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Employee {

    private static final String TABLE_NAME = "EMPLOYEE";
    private EmployeeRepository repo;
    private DataSource dataSource = Database.getDataSource();
    private Connection connection;

    @BeforeEach
    void setup() {
        SqlRunner.dropTablesAndCreateEmptyTables();
        repo = EmployeeRepository.getInstance();
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
        org.assertj.core.api.Assertions.assertThat(repo.tableExists() == true);
    }

}
