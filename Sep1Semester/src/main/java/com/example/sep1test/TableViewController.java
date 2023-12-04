package com.example.sep1test;
import com.example.sep1test.Projects.Commercial;
import com.example.sep1test.Projects.Residential;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class TableViewController implements Initializable
{

  //Residential
  @FXML
  private TableColumn<Residential, String> nameOfProject;

  @FXML
  private TableColumn<Residential, String> budget;

  @FXML
  private TableColumn<Residential, String> timeline;

  @FXML
  private TableColumn<Residential, String> size;

  @FXML
  private TableColumn<Residential, String> numberOfKitchens;
  @FXML
  private TableColumn<Residential, String> numberOfBathrooms;

  @FXML
  private TableColumn<Residential, String> numberOfPlumbingRooms;

  @FXML
  private TableColumn<Residential, String> renovated;


  @FXML
  private TableView<Residential> resTable;


  //Commercial
  @FXML
  private TableColumn<Commercial, String> cNameOfProject;

  @FXML
  private TableColumn<Commercial, String> cBudget;
  @FXML
  private TableView<Commercial> comTable;


  @FXML
  private Label outputLabel;


  public void refreshTableView() {
    if (resTable != null && resTable.getItems() != null) {
      resTable.setItems(FXCollections.observableArrayList(resTable.getItems()));
    }
  }


  public TableView<Residential> getResTable() {
    return resTable;
  }

  //Residential
  ObservableList<Residential> initialDataRes(){

    Residential r1 = new Residential("test","20",10,4,2,1,2,true);
    Residential r2 = new Residential("sample","20",2,1,3,2,1,false);

    return FXCollections.observableArrayList(r1,r2);
  }

  //Commercial
  ObservableList<Commercial> initialDataCom(){

    Commercial r3 = new Commercial("Hus","20",10,200,2,"Ingen ide");
    Commercial r4 = new Commercial("Hus2","20",10,200,2,"Ingen ide");

    return FXCollections.observableArrayList(r3,r4);
  }

  //!!!Should be moved!!!

  //click is the onAction in the fxml "ctrl + right click" on click to see where to edit
  public void clickNew(ActionEvent e) throws IOException {
    // Load the FXML file
    FXMLLoader loader = new FXMLLoader(getClass().getResource("create-scene.fxml"));
    Parent root = loader.load();

    // Create a new Stage for the pop-out window
    Stage popOutStage = new Stage();
    popOutStage.initModality(Modality.APPLICATION_MODAL);
    popOutStage.setTitle("Add new project");

    // Create content for the pop-out window (you can customize this)
    StackPane popOutLayout = new StackPane(root);

    // Set the content and show the pop-out window
    popOutStage.setScene(new Scene(popOutLayout, VBox.USE_PREF_SIZE, VBox.USE_PREF_SIZE));
    popOutStage.showAndWait();
  }

  //click is the onAction in the fxml "ctrl + right click" on click to see where to edit
  @FXML
  public void clickEdit(ActionEvent e) throws IOException {
    TableView.TableViewSelectionModel<Residential> selectionModel = resTable.getSelectionModel();

    if (selectionModel.isEmpty()){
      outputLabel.setText("Please select a project to edit");
    }else {
      //Setting the project to access in EditController
      Application.setResTable(resTable.getSelectionModel().getTableView());
      Application.setSelectProject(resTable.getSelectionModel().getSelectedItem(), resTable.getSelectionModel().getFocusedIndex());
      // Load the FXML file
      FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-scene.fxml"));
      Parent root = loader.load();

      // Create a new Stage for the pop-out window
      Stage popOutStage = new Stage();
      popOutStage.initModality(Modality.APPLICATION_MODAL);
      popOutStage.setTitle("edit project");

      // Create content for the pop-out window (you can customize this)
      StackPane popOutLayout = new StackPane(root);

      // Set the content and show the pop-out window
      popOutStage.setScene(new Scene(popOutLayout, VBox.USE_PREF_SIZE, VBox.USE_PREF_SIZE));
      popOutStage.showAndWait();
    }
  }

  @FXML
  private void clickRemove(ActionEvent e) throws IOException {
    TableView.TableViewSelectionModel<Residential> selectionModel = resTable.getSelectionModel();

    if (selectionModel.isEmpty()) {
      outputLabel.setText("You need to select data before deleting");
    } else {
      outputLabel.setText("Row was successfully deleted");
    }

    ObservableList<Integer> selectedIndices = selectionModel.getSelectedIndices();

    for (int i = selectedIndices.size() - 1; i >= 0; i--) {
      int selectedIndex = selectedIndices.get(i);
      selectionModel.clearSelection(selectedIndex);
      resTable.getItems().remove(selectedIndex);
    }
  }

  private void editData(){
    nameOfProject.setCellFactory(TextFieldTableCell.<Residential>forTableColumn());
    nameOfProject.setOnEditCommit(event -> {
      Residential residential = event.getTableView().getItems().get(event.getTablePosition().getRow());
      residential.setNameOfProject(event.getNewValue());

      //Message
      outputLabel.setText(residential.getNameOfProject() + " title was updated to " + event.getNewValue() + " at row " + (event.getTablePosition().getRow() + 1));

    });

    budget.setCellFactory(TextFieldTableCell.<Residential>forTableColumn());
    budget.setOnEditCommit(event -> {
      Residential residential = event.getTableView().getItems().get(event.getTablePosition().getRow());
      residential.setBudget(event.getNewValue());
      //Message
      outputLabel.setText(residential.getNameOfProject() + " title was updated to " + event.getNewValue() + " at row " + (event.getTablePosition().getRow() + 1));
    });

    timeline.setCellFactory(TextFieldTableCell.<Residential>forTableColumn());
    timeline.setOnEditCommit(event -> {
      Residential residential = event.getTableView().getItems().get(event.getTablePosition().getRow());
      residential.setTimeline(Integer.parseInt((event.getNewValue())));
      //Message
      outputLabel.setText(residential.getNameOfProject() + " title was updated to " + event.getNewValue() + " at row " + (event.getTablePosition().getRow() + 1));

    });

    size.setCellFactory(TextFieldTableCell.<Residential>forTableColumn());
    size.setOnEditCommit(event -> {
      Residential residential = event.getTableView().getItems().get(event.getTablePosition().getRow());
      residential.setSize(Double.parseDouble(event.getNewValue()));
      //Message
      outputLabel.setText(residential.getNameOfProject() + " title was updated to " + event.getNewValue() + " at row " + (event.getTablePosition().getRow() + 1));

    });

    numberOfKitchens.setCellFactory(TextFieldTableCell.<Residential>forTableColumn());
    numberOfKitchens.setOnEditCommit(event -> {
      Residential residential = event.getTableView().getItems().get(event.getTablePosition().getRow());
      residential.setNumberOfKitchens(Integer.parseInt(event.getNewValue()));
      //Message
      outputLabel.setText(residential.getNameOfProject() + " title was updated to " + event.getNewValue() + " at row " + (event.getTablePosition().getRow() + 1));

    });

    numberOfBathrooms.setCellFactory(TextFieldTableCell.<Residential>forTableColumn());
    numberOfBathrooms.setOnEditCommit(event -> {
      Residential residential = event.getTableView().getItems().get(event.getTablePosition().getRow());
      residential.setNumberOfBathrooms(Integer.parseInt(event.getNewValue()));
      //Message
      outputLabel.setText(residential.getNameOfProject() + " title was updated to " + event.getNewValue() + " at row " + (event.getTablePosition().getRow() + 1));

    });

    numberOfPlumbingRooms.setCellFactory(TextFieldTableCell.<Residential>forTableColumn());
    numberOfPlumbingRooms.setOnEditCommit(event -> {
      Residential residential = event.getTableView().getItems().get(event.getTablePosition().getRow());
      residential.setNumberOfPlumbingRooms(Integer.parseInt(event.getNewValue()));
      //Message
      outputLabel.setText(residential.getNameOfProject() + " title was updated to " + event.getNewValue() + " at row " + (event.getTablePosition().getRow() + 1));

    });

  }

  private void export(){
  }

  //Just to fill the table with data
  @FXML
  private void dummyData(ActionEvent e) throws IOException {
    Residential newData = new Residential("Naturhuset i Horsens","20000",165,165,1,2,3,true);
    resTable.getItems().add(newData);
  }

  //Setting values in tableView
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    //Residential
    nameOfProject.setCellValueFactory(new PropertyValueFactory<Residential, String>("nameOfProject"));
    budget.setCellValueFactory(new PropertyValueFactory<Residential, String>("budget"));
    timeline.setCellValueFactory(param -> {
      int timeline = param.getValue().getTimeline();
      return new SimpleStringProperty(Integer.toString(timeline));
    });
    size.setCellValueFactory(param -> {
      String rawSize = String.valueOf(param.getValue().getSize());
      String formattedSize = rawSize + " m2";
      return new SimpleStringProperty(formattedSize);
    });
    numberOfKitchens.setCellValueFactory(param -> {
      int numberOfKitchens = param.getValue().getNumberOfKitchens();
      return new SimpleStringProperty(Integer.toString(numberOfKitchens));
    });

    numberOfBathrooms.setCellValueFactory(param -> {
      int numberOfBathrooms = param.getValue().getNumberOfBathrooms();
      return new SimpleStringProperty(Integer.toString(numberOfBathrooms));
    });

    numberOfPlumbingRooms.setCellValueFactory(param -> {
      int numberOfPlumbingRooms = param.getValue().getNumberOfPlumbingRooms();
      return new SimpleStringProperty(Integer.toString(numberOfPlumbingRooms));
    });

     /* The old way of doing the same thing above.
     numberOfPlumbingRooms.setCellValueFactory(new PropertyValueFactory<Residential, String>("numberOfPlumbingRooms"));
    */

    /*
    Not working FIX
    renovated.setCellValueFactory(new PropertyValueFactory<>("renovated"));
    */

    //Dummydata
     // resTable.setItems(initialDataRes());


    //Commercial
    cNameOfProject.setCellValueFactory(new PropertyValueFactory<Commercial, String>("nameOfProject"));
    cBudget.setCellValueFactory(new PropertyValueFactory<Commercial, String>("budget"));
    comTable.setItems(initialDataCom());

    //Industrial

    //TO DO

    //Road

    //TO DO

    Application.setResTable(resTable);


    //Residential
    editData();
  }



}