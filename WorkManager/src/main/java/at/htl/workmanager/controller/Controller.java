package at.htl.workmanager.controller;

import at.htl.workmanager.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView<Employee> employee_list;

    @FXML
    private TableView<Schedule> planView;


    private List<Manager> managerList;
    private List<Employee> employeeList;
    private List<Schedule> scheduleList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MemberRepository Mrepo = MemberRepository.getInstance();
        EmployeeRepository empRepo = EmployeeRepository.getInstance();
        ScheduleRepository scheduleRepo = ScheduleRepository.getInstance();
        RoleRepository roleRepository = RoleRepository.getInstance();

        managerList = new LinkedList<Manager>();
        employeeList = new LinkedList<Employee>();
        scheduleList = new LinkedList<Schedule>();


        if(Mrepo.tableExists() && empRepo.tableExists() && scheduleRepo.tableExists() && roleRepository.tableExists()) {
            System.out.println("Database is functioning!");
        }
        else
        {
            System.out.println("Error couldn't connect to Database or something else!");
        }
    }
}
