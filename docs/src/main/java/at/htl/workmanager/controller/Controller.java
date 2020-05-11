package at.htl.workmanager.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button signInBtn;

    @FXML
    private void handleButtonAction(ActionEvent event) {
//        try {
//            App.setRoot("AccountWindow");
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    @FXML
    private void OnMouseClicked(ActionEvent e) {
//        try {
//            App.setRoot("AccountWindow");
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signInBtn.setOnAction(this::handleButtonAction);
    }
}
