module com.example.sep1test {
  requires javafx.controls;
  requires javafx.fxml;
    requires com.google.gson;

  opens com.example.sep1test to com.google.gson, javafx.fxml;
  exports com.example.sep1test;
    exports com.example.sep1test.Projects;
    opens com.example.sep1test.Projects to javafx.fxml, com.google.gson;
}