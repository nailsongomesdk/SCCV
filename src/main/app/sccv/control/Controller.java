package main.app.sccv.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.app.sccv.model.BuySell;
import main.app.sccv.model.Product;
import main.app.sccv.model.payment.Payment;
import main.app.sccv.model.person.Buyer;
import main.app.sccv.model.person.Seller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {
  private final List<Buyer> buyersList = new ArrayList<>();
  private final List<Seller> sellersList = new ArrayList<>();
  private final List<Product> cartList = new ArrayList<>();

  // Client
  @FXML
  private TextField clientNameInput;
  @FXML
  private TextField clientCPFInput;
  @FXML
  private TextField clientWalletInput;
  @FXML
  private Button clientSaveButton;
  @FXML
  private Button clientEditButton;
  @FXML
  private Button clientCancelButton;
  @FXML
  private Button clientDeleteButton;
  @FXML
  private TableView<Buyer> clientTable;
  @FXML
  private TableColumn<Buyer, String> clientNameColumn;
  @FXML
  private TableColumn<Buyer, String> clientCPFColumn;
  @FXML
  private TableColumn<Buyer, Double> clientWalletColumn;

  // Seller
  @FXML
  private TextField sellerNameInput;
  @FXML
  private TextField sellerCNPJInput;
  @FXML
  private TextField sellerWalletInput;
  @FXML
  private Button sellerSaveButton;
  @FXML
  private Button sellerEditButton;
  @FXML
  private Button sellerCancelButton;
  @FXML
  private Button sellerDeleteButton;
  @FXML
  private TableView<Seller> sellerTable;
  @FXML
  private TableColumn<Seller, String> sellerNameColumn;
  @FXML
  private TableColumn<Seller, String> sellerCNPJColumn;
  @FXML
  private TableColumn<Seller, Double> sellerWalletColumn;
  @FXML
  private Seller selectedSeller;

  // Product
  @FXML
  private TextField productNameInput;
  @FXML
  private TextField productBarcodeInput;
  @FXML
  private TextField productPriceInput;
  @FXML
  private Button productSaveButton;
  @FXML
  private Button productEditButton;
  @FXML
  private Button productCancelButton;
  @FXML
  private Button productDeleteButton;
  @FXML
  private TableView<Product> productTable;
  @FXML
  private TableColumn<Product, String> productNameColumn;
  @FXML
  private TableColumn<Product, Double> productPriceColumn;
  @FXML
  private TableColumn<Product, String> productBarcodeColumn;

  // BuySell
  @FXML
  private TextField buySellCNPJSellerInput;
  @FXML
  private TextField buySellCPFClientInput;
  @FXML
  private TextField buySellProductCodeInput;
  @FXML
  private TextField buySellProductNameInput;
  @FXML
  private TextField buySellTotalInput;
  @FXML
  private Button buySellAddButton;
  @FXML
  private Button buySellEditButton;
  @FXML
  private Button buySellCancelButton;
  @FXML
  private Button buySellDeleteButton;
  @FXML
  private TableView<BuySell> buySellTable;
  @FXML
  private TableColumn<BuySell, String> buySellProductCodeColumn;
  @FXML
  private TableColumn<BuySell, String> buySellProductNameColumn;
  @FXML
  private TableColumn<BuySell, String> buySellProductPriceColumn;
  @FXML
  private BuySell selectedBuySell;

  // Payment
  @FXML
  private ComboBox<Payment> selectPaymentMethod;

  @Override
  public void initialize(URL location, ResourceBundle resource) {

    clientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    clientCPFColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    clientWalletColumn.setCellValueFactory(new PropertyValueFactory<>("wallet"));

    sellerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    sellerCNPJColumn.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
    sellerWalletColumn.setCellValueFactory(new PropertyValueFactory<>("wallet"));

    productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    productBarcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));

    buySellProductCodeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
    buySellProductCodeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    buySellProductCodeColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


  }

  private void getUpdate(TableView table, List array) {
    table.getItems().clear();
    for (Object item : array) {
      table.getItems().add(item);
    }
  }

  private void cleanFields(TextField... params) {
    for (TextField input : params) {
      input.setText("");
    }
  }

  private void deleteFunction(TableView table, List list) {
    try {
      int index = table.getSelectionModel().getSelectedIndex();
      list.remove(index);
      getUpdate(table, list);
    } catch (Exception e) {
      alert("error", e.getMessage());
    }
  }

  private void alert(String type, String erro) {
    switch (type.toUpperCase(Locale.ROOT)) {
      case "WARNING":
        Alert alertaWarning = new Alert(Alert.AlertType.WARNING);
        alertaWarning.setContentText("por favor, preencha os campos em branco");
        alertaWarning.show();
        break;
      case "ERROR":
        Alert alertaError = new Alert(Alert.AlertType.ERROR);
        alertaError.setContentText(erro);
        alertaError.show();
        break;
      case "CONFIRM":
        Alert alertaConfirm = new Alert(Alert.AlertType.ERROR);
        alertaConfirm.setContentText("cadastro realizado com sucesso");
        alertaConfirm.show();
        break;
    }


  }

  // Handle Client
  @FXML
  public void handleSaveClient(ActionEvent event) {
    if ((clientNameInput.getText() != null && ! clientNameInput.getText().isEmpty())) {
      if ((clientCPFInput.getText() != null && ! clientCPFInput.getText().isEmpty())) {
        if ((clientWalletInput.getText() != null && ! clientWalletInput.getText().isEmpty())) {
          Buyer p = new Buyer(clientNameInput.getText(), clientCPFInput.getText(), Double.parseDouble(clientWalletInput.getText()));
          clientTable.getItems().add(p);
          buyersList.add(p);
        } else {
          alert("Warning", "");
        }
      } else {
        alert("warning", "");
      }
    } else {
      alert("warning", "");
    }

    // Limpa os inputs
    cleanFields(clientNameInput, clientCPFInput, clientWalletInput);
  }

  @FXML
  public void handleEditClient(ActionEvent event) {
    Buyer buyerTable = clientTable.getSelectionModel().getSelectedItem();

    if ("Editar".equals(clientEditButton.getText())) {
      clientNameInput.setText(buyerTable.getName());
      clientCPFInput.setText(buyerTable.getCpf());
      clientWalletInput.setText(String.valueOf(buyerTable.getWallet()));

      clientSaveButton.setDisable(true);
      clientDeleteButton.setDisable(true);
      clientEditButton.setText("Salvar");
    } else {
      buyerTable.setName(clientNameInput.getText());
      buyerTable.setCpf(clientCPFInput.getText());
      buyerTable.setWallet(Double.parseDouble(clientWalletInput.getText()));

      buyersList.set(clientTable.getSelectionModel().getSelectedIndex(), buyerTable);


      getUpdate(clientTable, buyersList);
      clientSaveButton.setDisable(false);
      clientDeleteButton.setDisable(false);
      cleanFields(clientNameInput, clientCPFInput, clientWalletInput);
      clientEditButton.setText("Editar");
    }
  }

  @FXML
  public void handleCancelClient(ActionEvent event) {
    cleanFields(clientNameInput, clientCPFInput, clientWalletInput);
    clientEditButton.setText("Editar");
    clientSaveButton.setDisable(false);
    clientDeleteButton.setDisable(false);
    clientNameInput.requestFocus();
  }

  @FXML
  public void handleDeleteClient(ActionEvent event) {
    deleteFunction(clientTable, buyersList);
  }

  // Handle Seller
  @FXML
  public void handleSaveSeller(ActionEvent event) {
    if ((sellerNameInput.getText() != null && ! sellerNameInput.getText().isEmpty())) {
      if ((sellerCNPJInput.getText() != null && ! sellerCNPJInput.getText().isEmpty())) {
        if ((sellerWalletInput.getText() != null && ! sellerWalletInput.getText().isEmpty())) {
          Seller s = new Seller(sellerNameInput.getText(), sellerCNPJInput.getText(), Double.parseDouble(sellerWalletInput.getText()));
          sellerTable.getItems().add(s);
          sellersList.add(s);
        }
      }
    }

    // Limpa os inputs
    cleanFields(sellerNameInput, sellerCNPJInput, sellerWalletInput);
  }

  @FXML
  public void handleEditSeller(ActionEvent event) {
    Seller seller = sellerTable.getSelectionModel().getSelectedItem();

    if ("Editar".equals(sellerEditButton.getText())) {
      sellerNameInput.setText(seller.getName());
      sellerCNPJInput.setText(seller.getCnpj());
      sellerWalletInput.setText(String.valueOf(seller.getWallet()));

      sellerSaveButton.setDisable(true);
      sellerDeleteButton.setDisable(true);
      sellerEditButton.setText("Salvar");
    } else {
      seller.setName(sellerNameInput.getText());
      seller.setCnpj(sellerCNPJInput.getText());
      seller.setWallet(Double.parseDouble(sellerWalletInput.getText()));

      sellersList.set(sellerTable.getSelectionModel().getSelectedIndex(), seller);


      getUpdate(sellerTable, sellersList);
      sellerSaveButton.setDisable(false);
      sellerDeleteButton.setDisable(false);
      cleanFields(sellerNameInput, sellerCNPJInput, sellerWalletInput);
      sellerEditButton.setText("Editar");
    }
  }


  @FXML
  public void handleCancelSeller(ActionEvent event) {
    cleanFields(sellerNameInput, sellerCNPJInput, sellerWalletInput);
  }

  @FXML
  public void handleDeleteSeller(ActionEvent event) {
    deleteFunction(sellerTable, sellersList);
  }

  // Handle Product
  @FXML
  public void handleSaveProduct(ActionEvent event) {
    if ((productNameInput.getText() != null && ! productNameInput.getText().isEmpty())) {
      if ((productBarcodeInput.getText() != null && ! productBarcodeInput.getText().isEmpty())) {
        if ((productPriceInput.getText() != null && ! productPriceInput.getText().isEmpty())) {
          Product p = new Product(productNameInput.getText(), Double.parseDouble(productPriceInput.getText()), productBarcodeInput.getText());
          productTable.getItems().add(p);
          cartList.add(p);
        }
      }
    }

    // Limpa os inputs
    cleanFields(productNameInput, productBarcodeInput, productPriceInput);
  }

  @FXML
  public void handleEditProduct(ActionEvent event) {
    Product product = productTable.getSelectionModel().getSelectedItem();

    if ("Editar".equals(productEditButton.getText())) {
      productNameInput.setText(product.getName());
      productBarcodeInput.setText(product.getBarcode());
      productPriceInput.setText(String.valueOf(product.getPrice()));

      productSaveButton.setDisable(true);
      productDeleteButton.setDisable(true);
      productEditButton.setText("Salvar");
    } else {
      product.setName(productNameInput.getText());
      product.setBarcode(productBarcodeInput.getText());
      product.setPrice(Double.parseDouble(productPriceInput.getText()));

      cartList.set(productTable.getSelectionModel().getSelectedIndex(), product);


      getUpdate(productTable, cartList);
      productSaveButton.setDisable(false);
      productDeleteButton.setDisable(false);
      cleanFields(productNameInput, productBarcodeInput, productPriceInput);
      productEditButton.setText("Editar");
    }
  }

  @FXML
  public void handleCancelProduct(ActionEvent event) {
    cleanFields(productNameInput, productBarcodeInput, productPriceInput);
  }

  @FXML
  public void handleDeleteProduct(ActionEvent event) {
    deleteFunction(productTable, cartList);
  }

  // Handle BuySell
  @FXML
  public void handleAddProductBuySell(ActionEvent actionEvent) {
  }

  @FXML
  public void handleEditBuySell() {
    System.out.println("Botão editar venda funcionando!");
  }

  @FXML
  public void handleCancelBuySell(ActionEvent event) {
    // Limpa os inputs
    buySellCNPJSellerInput.setText("");
    buySellCPFClientInput.setText("");
  }

  @FXML
  public void handleDeleteBuySell(ActionEvent event) {
    System.out.println("Botão apagar produto funcionando!");
  }
}
