import at.htl.workmanager.database.Database;
import at.htl.workmanager.model.Repository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.sql.DataSource;

public class Test_Employee {

    String TABLE_NAME = "EMPLOYEE";
    Repository repo;
    DataSource dataSource = Database.getDataSource();

    @BeforeEach
    void beforeEach() {
        repo = Repository.getInstance();

        if (repo.tableExists()) {
            repo.dropTable();
        }
        repo.createTables();
    }

}
