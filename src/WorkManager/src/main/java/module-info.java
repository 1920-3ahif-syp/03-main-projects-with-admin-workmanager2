module at.htl.workmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.derby.client;
    requires org.apache.derby.commons;
    requires org.apache.derby.tools;
    requires org.mybatis;

    opens at.htl.workmanager.view.gui to javafx.fxml;
    exports at.htl.workmanager.view.gui;
    exports at.htl.workmanager.controller;
    exports at.htl.workmanager.model.observer;
    exports at.htl.workmanager.model.users;
    exports at.htl.workmanager.model.workPlan;
}