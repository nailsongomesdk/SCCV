package main.app.sccv.control;

import main.app.sccv.model.payment.Payment;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;

public class Controller {
  // Client
  @FXML
  private TableColumn<?, ?> columnClientName;
  @FXML
  public TableColumn<?, ?> columnClientCPF;
  @FXML
  public TableColumn<?, ?> columnClientWallet;
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
  public void handleSaveClientName(ActionEvent event) {
    try {
      if ((inputClientName.getText() != null && !inputClientName.getText().isEmpty())) {
        columnClientName.setText(inputClientName.getText());

        if ((inputClientCPF.getText() != null && !inputClientCPF.getText().isEmpty())) {
          columnClientCPF.setText(inputClientCPF.getText());

          if ((inputClientWallet.getText() != null && !inputClientWallet.getText().isEmpty())) {
            columnClientWallet.setText(inputClientWallet.getText());
          }
        }
      }
    } catch (Exception e) {
      System.err.println("Error: " + e + "não pode ficar vazio.");
    }
  }

  @FXML
  public void handleEditClient(ActionEvent event) {
    System.out.println("Botão editar cliente funcionando!");
  }

  @FXML
  public void handleCancelClient(ActionEvent event) {
    System.out.println("Botão cancelar cliente funcionando!");
  }

  @FXML
  public void handleDeleteClient(ActionEvent event) {
    System.out.println("Botão apagar cliente funcionando!");
  }

  @FXML
  public void handleListClient(ActionEvent event) {
    System.out.println("Botão listar cliente funcionando!");
  }

  // Handle Seller
  @FXML
  public void handleSaveSeller(ActionEvent event) {
    System.out.println("Botão salvar vendedor funcionando!");
  }

  @FXML
  public void handleEditSeller(ActionEvent event) {
    System.out.println("Botão editar vendedor funcionando!");
  }

  @FXML
  public void handleCancelSeller(ActionEvent event) {
    System.out.println("Botão cancelar vendedor funcionando!");
  }

  @FXML
  public void handleDeleteSeller(ActionEvent event) {
    System.out.println("Botão apagar vendedor funcionando!");
  }

  @FXML
  public void handleListSeller(ActionEvent event) {
    System.out.println("Botão listar vendedor funcionando!");
  }

  // Handle Product
  @FXML
  public void handleSaveProduct(ActionEvent event) {
    System.out.println("Botão salvar produto funcionando!");
  }

  @FXML
  public void handleEditProduct(ActionEvent event) {
    System.out.println("Botão editar produto funcionando!");
  }

  @FXML
  public void handleCancelProduct(ActionEvent event) {
    System.out.println("Botão cancelar produto funcionando!");
  }

  @FXML
  public void handleDeleteProduct(ActionEvent event) {
    System.out.println("Botão apagar produto funcionando!");
  }

  @FXML
  public void handleListProduct(ActionEvent event) {
    System.out.println("Botão listar produto funcionando!");
  }

  // Handle Sell
  @FXML
  public void handleSaveSell(ActionEvent event) {
    System.out.println("Botão salvar venda funcionando!");
  }

  @FXML
  public void handleEditSell(ActionEvent event) {
    System.out.println("Botão editar venda funcionando!");
  }

  @FXML
  public void handleCancelSell(ActionEvent event) {
    System.out.println("Botão cancelar produto funcionando!");
  }

  @FXML
  public void handleDeleteSell(ActionEvent event) {
    System.out.println("Botão apagar produto funcionando!");
  }

  @FXML
  public void handleListSell(ActionEvent event) {
    System.out.println("Botão listar venda funcionando!");
  }

  // Payment Method
  @FXML
  public void handleSelectPaymentMethod(ActionEvent event) {
    System.out.print("\t1 - Pix\n\t2 - Débito\n\t3 - Crédito\n\t4 - Boleto\nSelecione a forma de pagamento: ");
  }
}
