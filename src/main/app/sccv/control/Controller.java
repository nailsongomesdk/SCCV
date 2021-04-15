package main.app.sccv.control;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
  @FXML
  private Buyer selectedBuyer;

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
  @FXML
  private Product selectedProduct;

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
    // Verifica se é a tabela de clientes
    //if (clientTable) {}
    clientNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    clientCPFColumn.setCellValueFactory(new PropertyValueFactory<>("cpf"));
    clientWalletColumn.setCellValueFactory(new PropertyValueFactory<>("wallet"));

    // Verifica se é a tabela de vendedores
    /*if (sellerTable) {
      sellerNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
      sellerCNPJColumn.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
      sellerWalletColumn.setCellValueFactory(new PropertyValueFactory<>("wallet"));
    }*/

    // Verifica se é a tabela de produtos
    /*if (productTable) {
      productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
      productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
      productBarcodeColumn.setCellValueFactory(new PropertyValueFactory<>("barcode"));
    }*/
    update();

    clientTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
      @Override
      public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        selectedBuyer = (Buyer) newValue;
      }
    });
  }

  private void update() {
    clientTable.getItems().clear();

    for (Object item : buyersList) {
      clientTable.getItems().add((Buyer) item);
    }
  }

  private void cleanFields(String local) {
    switch (local) {
      case "clients":
        clientNameInput.setText("");
        clientCPFInput.setText("");
        clientWalletInput.setText("");
        break;
      case "seller":
        sellerNameInput.setText("");
        sellerWalletInput.setText("");
        sellerCNPJInput.setText("");
        break;
      case "product":
        productNameInput.setText("");
        productBarcodeInput.setText("");
        productPriceInput.setText("");
        break;
      case "buysell":
        buySellCNPJSellerInput.setText("");
        buySellCPFClientInput.setText("");
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
        }
      }
    }

    // Limpa os inputs
    cleanFields("clients");
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

      update();
      clientSaveButton.setDisable(false);
      clientDeleteButton.setDisable(false);
      cleanFields("clients");
      clientEditButton.setText("Editar");
    }
  }

  @FXML
  public void handleCancelClient(ActionEvent event) {
    // Limpa os inputs
    cleanFields("clients");
  }

  @FXML
  public void handleDeleteClient(ActionEvent event) {
    int index = clientTable.getSelectionModel().getSelectedIndex();
    buyersList.remove(index);
    update();

  }

  // Handle Seller
  @FXML
  public void handleSaveSeller(ActionEvent event) {
    if ((sellerNameInput.getText() != null && ! sellerNameInput.getText().isEmpty())) {
      if ((sellerCNPJInput.getText() != null && ! sellerCNPJInput.getText().isEmpty())) {
        if ((sellerWalletInput.getText() != null && ! sellerWalletInput.getText().isEmpty())) {
          sellerTable.getItems().add(new Seller(sellerNameInput.getText(), sellerCNPJInput.getText(), Double.parseDouble(sellerWalletInput.getText())));
        }
      }
    }

    // Limpa os inputs
    cleanFields("seller");
  }

  @FXML
  public void handleEditSeller(ActionEvent event) {
    System.out.println("Botão editar vendedor funcionando!");
  }

  @FXML
  public void handleCancelSeller(ActionEvent event) {
    // Limpa os inputs
    sellerNameInput.setText("");
    sellerCNPJInput.setText("");
    sellerWalletInput.setText("");
  }

  @FXML
  public void handleDeleteSeller(ActionEvent event) {
    System.out.println("Botão apagar vendedor funcionando!");
  }

  // Handle Product
  @FXML
  public void handleSaveProduct(ActionEvent event) {
    if ((productNameInput.getText() != null && ! productNameInput.getText().isEmpty())) {
      if ((productBarcodeInput.getText() != null && ! productBarcodeInput.getText().isEmpty())) {
        if ((productPriceInput.getText() != null && ! productPriceInput.getText().isEmpty())) {
          productTable.getItems().add(new Product(productNameInput.getText(), Double.parseDouble(productBarcodeInput.getText()), productPriceInput.getText()));
        }
      }
    }

    // Limpa os inputs
    cleanFields("product");
  }

  @FXML
  public void handleEditProduct(ActionEvent event) {
    System.out.println("Botão editar produto funcionando!");
  }

  @FXML
  public void handleCancelProduct(ActionEvent event) {
    // Limpa os inputs
    productNameInput.setText("");
    productBarcodeInput.setText("");
    productPriceInput.setText("");
  }

  @FXML
  public void handleDeleteProduct(ActionEvent event) {
    System.out.println("Botão apagar produto funcionando!");
  }

  // Handle BuySell
  @FXML
  public void handleAddProductBuySell(ActionEvent actionEvent) {
  }

  @FXML
  public void handleEditBuySell(ActionEvent event) {
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
