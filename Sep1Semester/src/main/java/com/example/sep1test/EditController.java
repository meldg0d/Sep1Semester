package com.example.sep1test;

import com.example.sep1test.Projects.Commercial;
import com.example.sep1test.Projects.Industrial;
import com.example.sep1test.Projects.Residential;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class EditController implements Initializable {

    private int index = Application.getSelectedIndex();

    @FXML
    private Tab residential;

    @FXML
    private Tab commercial;

    @FXML
    private Tab industrial;

    @FXML
    private Tab road;


    @FXML
    private TextField resName;

    @FXML
    private TextField resBudget;

    @FXML
    private TextField resTimeline;

    @FXML
    private TextField resSize;

    @FXML
    private TextField numberOfKitchens;

    @FXML
    private TextField numberOfBathrooms;

    @FXML
    private TextField numberOfPlumbingRooms;

    public void getData(){
        Project selectedProject = Application.getSelectedProject();

        //Check what type of project
        if (Application.getSelectedProject() instanceof Residential){
            Residential resSelectedProject = (Residential) selectedProject;

            //disables not active project-types
            road.setDisable(true);
            industrial.setDisable(true);
            commercial.setDisable(true);

            resName.setText(resSelectedProject.getNameOfProject());
            resBudget.setText(resSelectedProject.getBudget());
            resTimeline.setText(String.valueOf(resSelectedProject.getTimeline()));
            resSize.setText(String.valueOf(resSelectedProject.getSize()));
            numberOfKitchens.setText(String.valueOf(resSelectedProject.getNumberOfKitchens()));
            numberOfBathrooms.setText(String.valueOf(resSelectedProject.getNumberOfBathrooms()));
            numberOfPlumbingRooms.setText(String.valueOf(resSelectedProject.getNumberOfPlumbingRooms()));
        } else if (Application.getSelectedProject() instanceof Commercial) {
            //disables not active project-types
            road.setDisable(true);
            industrial.setDisable(true);
            residential.setDisable(true);

            //To do
            System.out.println("This is Commercial");
        } else if (Application.getSelectedProject() instanceof Industrial) {
            //disables not active project-types
            road.setDisable(true);
            commercial.setDisable(true);
            residential.setDisable(true);
            //To do
            System.out.println("This is Industrial");
        }else {
            //disables not active project-types
            industrial.setDisable(true);
            commercial.setDisable(true);
            residential.setDisable(true);
            //To do
            System.out.println("This is Road");
        }


    }

    public void setData(){
        Project selectedProject = Application.getSelectedProject();
        //Commercial
        if (Application.getSelectedProject() instanceof Residential){
            Residential resSelectedProject = (Residential) selectedProject;

            resSelectedProject.setNameOfProject(resName.getText());
            resSelectedProject.setBudget(resBudget.getText());
            resSelectedProject.setTimeline(Integer.parseInt(resTimeline.getText()));
            resSelectedProject.setSize(Double.parseDouble(resSize.getText()));
            resSelectedProject.setNumberOfKitchens(Integer.parseInt(numberOfKitchens.getText()));
            resSelectedProject.setNumberOfBathrooms(Integer.parseInt(numberOfBathrooms.getText()));
            resSelectedProject.setNumberOfPlumbingRooms(Integer.parseInt(numberOfPlumbingRooms.getText()));

            Application.editDataToTable(resSelectedProject);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Application.getSelectedProject() instanceof Residential){
            System.out.println("This is a Residential");
        }
        getData();

    }
}
