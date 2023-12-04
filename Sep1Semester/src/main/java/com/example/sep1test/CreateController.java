package com.example.sep1test;
import com.example.sep1test.Projects.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateController implements Initializable
{

    //Residential
    @FXML
    private TextField resName;

    @FXML
    private TextField resBudget;

    @FXML
    private TextField resTimeline;

    @FXML
    private TextField resSize;

    @FXML
    private TextField resNumberOfKitchens;

    @FXML
    private TextField resNumberOfBathrooms;

    @FXML
    private TextField resNumberOfPlumbingRooms;

    //BOOLEAN SHOULD BE ADDED HERE -> resIsNewBuild

    @FXML
    private Button addButton;

    //Error messages and such
    @FXML
    private Label msg;


    //Creates new Residential obj and sends it to the resTable
    @FXML
    private void resBtn(ActionEvent event){
        try {
            //If field is empty
            if (resBudget.getText().isEmpty()){
                //Implement default values here

                //Dummy to illustrate
                resBudget.setText("10");
            }

            //More if statements here


            //Creates a new Residential obj with parameteres from tex-fields
            Residential newData = new Residential(resName.getText(), resBudget.getText(),Integer.parseInt(resTimeline.getText()),Double.parseDouble(resSize.getText()),Integer.parseInt(resNumberOfKitchens.getText()),Integer.parseInt(resNumberOfBathrooms.getText()),Integer.parseInt(resNumberOfPlumbingRooms.getText()),true);


            //sends Residential obj to resTable
            Application.addDataToTable(newData);

            //Message that shows if everything worked
            msg.setTextFill(Paint.valueOf("#008000"));
            msg.setText("Project:" + newData.getNameOfProject() + " Was added to the list");

            //Clears text-fields
            resName.clear();
            resBudget.clear();
            resTimeline.clear();
            resSize.clear();
            resNumberOfKitchens.clear();
            resNumberOfBathrooms.clear();
            resNumberOfPlumbingRooms.clear();



        } catch (NumberFormatException e) {
            //Message that shows error. If a field is not filled correctly
            msg.setTextFill(Paint.valueOf("#FF0000"));
            msg.setText("Please use the right format");
            // Handle the case where the string is not a valid
            System.out.println("Invalid format");
        }

    }


    public CreateController() throws IOException {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}