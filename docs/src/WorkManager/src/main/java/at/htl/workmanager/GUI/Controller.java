package main.java.at.htl.workmanager.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button signInBtn;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            at.htl.workmanager.GUI.App.setRoot("AccountWindow");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void OnMouseClicked(ActionEvent e) {
        try {
            at.htl.workmanager.GUI.App.setRoot("AccountWindow");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signInBtn.setOnAction(this::handleButtonAction);
    }
}
