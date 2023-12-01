package com.example.sep1test;
import com.example.sep1test.Projects.Residential;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;

public class Application extends javafx.application.Application
{
  @Override public void start(Stage stage) throws IOException
  {
    FXMLLoader fxmlLoader = new FXMLLoader(
            Application.class.getResource("main-scene.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 900, 450);
    stage.setTitle("Tableview");
    stage.setScene(scene);
    stage.show();
  }


  private static TableView<Residential> resTable;
  public static void setResTable(TableView<Residential> table) {
    resTable = table;
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