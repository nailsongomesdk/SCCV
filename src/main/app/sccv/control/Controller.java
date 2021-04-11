package main.app.sccv.control;

import main.app.sccv.model.payment.Payment;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
  // Client
  @FXML
  private TextField inputClientName;

  @FXML
  private TextField inputClientCPF;

  @FXML
  private TextField inputClientWallet;

  // Seller
  @FXML
  private TextField inputSellerName;

  @FXML
  private TextField inputSellerCPF;

  @FXML
  private TextField inputSellerWallet;

  // Product
  @FXML
  private TextField inputProductName;

  @FXML
  private TextField inputProductPrice;

  @FXML
  private TextField inputProductBarcode;

  // Payment
  @FXML
  private ComboBox<Payment> selectPaymentMethod;

  // Handle Client
  @FXML
  public void handleSaveClient(MouseEvent mouseEvent) {
    System.out.println("Botão salvar cliente funcionando!");
  }

  @FXML
  public void handleEditClient(MouseEvent mouseEvent) {
    System.out.println("Botão editar cliente funcionando!");
  }

  @FXML
  public void handleCancelClient(MouseEvent mouseEvent) {
    System.out.println("Botão cancelar cliente funcionando!");
  }

  @FXML
  public void handleDeleteClient(MouseEvent mouseEvent) {
    System.out.println("Botão apagar cliente funcionando!");
  }

  @FXML
  public void handleListClient(MouseEvent mouseEvent) {
    System.out.println("Botão listar cliente funcionando!");
  }

  // Handle Seller
  @FXML
  public void handleSaveSeller(MouseEvent mouseEvent) {
    System.out.println("Botão salvar vendedor funcionando!");
  }

  @FXML
  public void handleEditSeller(MouseEvent mouseEvent) {
    System.out.println("Botão editar vendedor funcionando!");
  }

  @FXML
  public void handleCancelSeller(MouseEvent mouseEvent) {
    System.out.println("Botão cancelar vendedor funcionando!");
  }

  @FXML
  public void handleDeleteSeller(MouseEvent mouseEvent) {
    System.out.println("Botão apagar vendedor funcionando!");
  }

  @FXML
  public void handleListSeller(MouseEvent mouseEvent) {
    System.out.println("Botão listar vendedor funcionando!");
  }

  // Handle Product
  @FXML
  public void handleSaveProduct(MouseEvent mouseEvent) {
    System.out.println("Botão salvar produto funcionando!");
  }

  @FXML
  public void handleEditProduct(MouseEvent mouseEvent) {
    System.out.println("Botão editar produto funcionando!");
  }

  @FXML
  public void handleCancelProduct(MouseEvent mouseEvent) {
    System.out.println("Botão cancelar produto funcionando!");
  }

  @FXML
  public void handleDeleteProduct(MouseEvent mouseEvent) {
    System.out.println("Botão apagar produto funcionando!");
  }

  @FXML
  public void handleListProduct(MouseEvent mouseEvent) {
    System.out.println("Botão listar produto funcionando!");
  }

  // Handle Sell
  @FXML
  public void handleSaveSell(MouseEvent mouseEvent) {
    System.out.println("Botão salvar venda funcionando!");
  }

  @FXML
  public void handleEditSell(MouseEvent mouseEvent) {
    System.out.println("Botão editar venda funcionando!");
  }

  @FXML
  public void handleCancelSell(MouseEvent mouseEvent) {
    System.out.println("Botão cancelar produto funcionando!");
  }

  @FXML
  public void handleDeleteSell(MouseEvent mouseEvent) {
    System.out.println("Botão apagar produto funcionando!");
  }

  @FXML
  public void handleListSell(MouseEvent mouseEvent) {
    System.out.println("Botão listar venda funcionando!");
  }

  // Payment Method
  @FXML
  public void handleSelectPaymentMethod(MouseEvent mouseEvent) {
    System.out.print("\t1 - Pix\n\t2 - Débito\n\t3 - Crédito\n\t4 - Boleto\nSelecione a forma de pagamento: ");
  }
}
