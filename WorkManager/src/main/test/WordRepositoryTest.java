package test;


import at.htl.workmanager.database.Database;
import at.htl.workmanager.model.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.db.output.Outputs.output;

class WordRepositoryTest {

    String TABLE_NAME = "WORD";
    EmployeeRepository employeeRepository;
    DataSource dataSource = Database.getDataSource();

    @BeforeEach
    void beforeEach() {
        employeeRepository = EmployeeRepository.getInstance();

        if (employeeRepository.tableExists()) {
            employeeRepository.dropTables();
        }
//        employeeRepository.createTable();
    }

    /*
    @Test
    void createTable() {
        employeeRepository = new WordRepository();
        employeeRepository.createTable();

    }*/


/*
   @Test
   void test020_insertWord(){
       Word word01 = new Word("Hund", "dog");
       employeeRepository.createTable();
       employeeRepository.save(word01);

       assertThat(employeeRepository).isNotNull();
   }
*/

/*
   @Test
   void test030_deleteWord(){
       Word word01 = new Word("Hund", "dog");
       employeeRepository.save(word01);
       employeeRepository.delete(word01.getGermanWord());

       assertThat(employeeRepository).isNull();
   }

   @Test
   void test080_saveTwoWords() {
       Word word01 = new Word("Hund", "dog");
       Word word02 = new Word("Katze", "cat");

       WordRepository wordRepository = new WordRepository();
       wordRepository.createTable();
       wordRepository.save(word01);
       wordRepository.save(word02);

       Table wordTable = new Table(dataSource, TABLE_NAME);
       output(wordTable).toConsole();
       org.assertj.db.api.Assertions.assertThat(wordTable).hasNumberOfRows(2);
   }

   @Test
   void test090_dropTable() {

       // act
       employeeRepository.dropTable();

       // assert
       assertThat(employeeRepository.tableExists() == false);
   }*/
}