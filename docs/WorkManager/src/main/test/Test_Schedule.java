import at.htl.workmanager.database.Database;
import at.htl.workmanager.database.SqlRunner;
import at.htl.workmanager.database.SqlScript;
import at.htl.workmanager.model.Manager;
import at.htl.workmanager.model.Repository;
import at.htl.workmanager.model.Schedule;
import org.junit.jupiter.api.*;

import javax.sql.DataSource;
import java.sql.Connection;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Test_Schedule {

    private static final String TABLE_NAME = "SCHEDULE";
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
        Schedule schedule;

    }

    @Test
    @Order(300)
    public void dropTables() {
        repo.dropTables();
        org.assertj.core.api.Assertions.assertThat(repo.tableExists(TABLE_NAME) == true);
    }

}