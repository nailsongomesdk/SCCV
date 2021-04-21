package main.app.sccv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.app.sccv.model.payment.PaymentEnum;
import main.app.sccv.model.payment.PaymentInterface;

public class Main extends Application {
  private Stage stage;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage mainStage) {
    stage = mainStage;
    stage.setTitle("Sistema de cadastro de compra e venda");
    initView();
    testEnum();
  }

  private void initView() {
    try {
      // Loads the .fxml file
      FXMLLoader view = new FXMLLoader();
      view.setLocation(Main.class.getResource("view/viewer/viewer.fxml"));
      Pane root = view.load();

      // Shows the layout scene
      Scene scene = new Scene(root, 800, 600);
      stage.setScene(scene);
      stage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void testEnum() {
    PaymentInterface payment = PaymentEnum.fromValue(1);

    if (payment != null) {
      System.out.println("Mês: " + payment.getPaymentValue() + ", " + payment.getPaymentType());
    }

    if (PaymentEnum.PIX_PAYMENT == payment) {
      System.out.println("O mês " + payment.getPaymentValue() + "º do ano é " + payment.getPaymentType());
    }
  }
}
