package main.app.sccv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    try {
      Parent root = FXMLLoader.load(getClass().getResource("view/menu/menu.fxml"));
      primaryStage.setTitle("Sistema de cadastro de compra e venda");
      primaryStage.setScene(new Scene(root, 800, 600));
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
