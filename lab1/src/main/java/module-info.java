module com.flex.lab1_tsoosi {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.flex.lab1_tsoosi to javafx.fxml;
  exports com.flex.lab1_tsoosi;
}