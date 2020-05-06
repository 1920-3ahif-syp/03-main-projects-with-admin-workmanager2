open module at.htl.workmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.derby.client;
    requires org.apache.derby.commons;
    requires org.apache.derby.tools;
    requires org.mybatis;

    //at.htl.workmanager.view to javafx.fxml;
    exports at.htl.workmanager.view;
    exports at.htl.workmanager.controller;
    exports at.htl.workmanager.model;
}