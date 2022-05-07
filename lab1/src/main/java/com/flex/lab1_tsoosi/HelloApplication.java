package com.flex.lab1_tsoosi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

  @Override
  public void start(Stage stage) {
    Drawing group = new Drawing();
    stage.setScene(new Scene(group));
    stage.show();
    stage.setResizable(true);
    stage.setFullScreen(false);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

