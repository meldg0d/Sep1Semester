package com.example.sep1test;
import com.example.sep1test.Projects.Residential;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Application extends javafx.application.Application
{


  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("main-scene.fxml"));
    Parent root = fxmlLoader.load();

    Scene scene = new Scene(root, 900, 450);
    stage.setTitle("TableView");
    stage.setScene(scene);


    //loader & saver
    TableViewController tableViewController = new TableViewController();
    List<Residential> data = resTable.getItems();

    stage.setOnCloseRequest(event -> {
      // Save data on application close
      DataService.saveData(data, "data.bin");

    });
    stage.show();

    // Load data on application start
    List<Residential> loadedData = DataService.loadData("data.bin");
    // Use loadedData to populate your TableView or wherever you need it
    if (loadedData != null) {
      data.addAll(loadedData); // Assuming 'data' is a modifiable list
      System.out.println(loadedData);
      tableViewController.refreshTableView(); //
    }

  }


  //export to Json
  public static void exportToJSON()
  {
    List<Residential> data = resTable.getItems();

    DataService.exportToJson(data,"web.json");
  }


  private static TableView<Residential> resTable;
  public static void setResTable(TableView<Residential> table) {
    resTable = table;
  }

  public static TableView<Residential> getResTable(){
    return resTable;
  }


  //Edit project
  private static Project selectedProject;
  private static int selectedIndex;

  public static void setSelectProject(Project project, int index){
    selectedProject = project;
    selectedIndex = index;
  }

  public static int getSelectedIndex() {
    return selectedIndex;
  }

  public static Project getSelectedProject() {
    return selectedProject;
  }

  public static void editDataToTable(Residential updatedData) {
    if (resTable != null) {
      int selectedIndex = getSelectedIndex();

      if (selectedIndex >= 0) {
        // Get the current list of items in the TableView
        ObservableList<Residential> items = resTable.getItems();

        // Replace the item at the selected index with the updated data
        items.set(selectedIndex, updatedData);

        //refresh the TableView to reflect the changes
        resTable.refresh();

        System.out.println("Updated data in row " + selectedIndex + ": " + updatedData);
      } else {
        System.out.println("No item selected in the TableView.");
      }
    }
  }


  public static void addDataToTable(Residential newData) {
    if (resTable != null) {
      resTable.getItems().add(newData);
    }
  }


  public static void main(String[] args)
  {
    launch();
  }
}