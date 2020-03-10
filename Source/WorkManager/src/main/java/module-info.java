module at.htl.workmanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens at.htl.workmanager.GUI to javafx.fxml;
    exports at.htl.workmanager.GUI;
}