///*
//package controller;
//
//import model.Word;
//import org.assertj.core.api.Assertions;
//import org.assertj.db.type.Table;
//import org.junit.jupiter.api.Test;
//
//import javax.sql.DataSource;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.as;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.db.output.Outputs.output;
//
//public class WordRepositoryTest2 {
//
//    String TABLE_NAME = "WORD";
//    WordRepository employeeRepository = new WordRepository();
//    DataSource dataSource = Database.getDataSource();
//
//
//    @Test
//    void test010_insertWord(){
//        employeeRepository.dropTable();
//
//        // arrange
//        Word word01 = new Word("Meerschweinchen", "guineapig");
//        Word word02 = new Word("Schildkröte", "turtle");
//
//        // act
//        employeeRepository.createTable();
//        employeeRepository.save(word01);
//        employeeRepository.save(word02);
//
//        // assert
//        Table wordTable = new Table(dataSource, TABLE_NAME);
//        output(wordTable).toConsole();
//        org.assertj.db.api.Assertions.assertThat(wordTable).hasNumberOfRows(2);
//    }
//
//
//  */
///*  @Test
//    void test020_(){
//
//        Word word01 = new Word("Meerschweinchen", "guineapig");
//
//        employeeRepository.createTable();
//        employeeRepository.save(word01);
//
//        List<Word> words = employeeRepository.getAllWords();
//
//            for (int i = 0; i < words.size(); i++) {
//                if (words.get(i).getGermanWord().equals(word01.getGermanWord())){
//                    System.out.println("Word already exists.");
//                }else {
//                    employeeRepository.save(word01);
//                }
//            }
//
//        Table wordTable = new Table(dataSource, TABLE_NAME);
//        output(wordTable).toConsole();
//
//        org.assertj.db.api.Assertions.assertThat(wordTable).hasNumberOfRows(2);
//
//    }*//*
//
//
//}
//*/
