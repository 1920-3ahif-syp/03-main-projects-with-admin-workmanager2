module main.java.at.htl.workmanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.htl.workmanager.GUI to javafx.fxml;
    exports main.java.at.htl.workmanager.GUI;
}