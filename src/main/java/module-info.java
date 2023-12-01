module com.example.sep1test {
  requires javafx.controls;
  requires javafx.fxml;
    requires XmlJsonParser;

    opens com.example.sep1test to javafx.fxml;
  exports com.example.sep1test;
    exports com.example.sep1test.Projects;
    opens com.example.sep1test.Projects to javafx.fxml;
}