package main.app.sccv.control;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.app.sccv.model.Product;
import main.app.sccv.model.payment.Payment;
import main.app.sccv.model.person.Buyer;
import main.app.sccv.model.person.Seller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private List<Seller> sellersList = new ArrayList<>();
    private List<Buyer> buyersList = new ArrayList<>();
    private List<Product> cartList = new ArrayList<>();
    private Buyer selecionada;

    // Client
    @FXML
    public TableView<Buyer> tableClient;
    @FXML
    public TableColumn<Buyer, String> columnClientCPF;
    @FXML
    public TableColumn<Buyer, Double> columnClientWallet;
    @FXML
    public Button saveClient;
    @FXML
    public Button editClient;
    @FXML
    public Button cancelClient;
    @FXML
    public Button deleteClient;
    // Seller
    @FXML
    public TableView<Seller> tableSeller;
    @FXML
    public TableColumn<Seller, String> columnSellerCNPJ;
    @FXML
    public TableColumn<Seller, Double> columnSellerWallet;
    // Product
    @FXML
    public TableView<Product> tableProduct;
    @FXML
    public TableColumn<Product, Double> columnProductPrice;
    @FXML
    public TableColumn<Product, String> columnProductBarcode;
    @FXML
    private TableColumn<Buyer, String> columnClientName;
    @FXML
    private TextField inputClientName;
    @FXML
    private TextField inputClientCPF;
    @FXML
    private TextField inputClientWallet;
    @FXML
    private TableColumn<Seller, String> columnSellerName;
    @FXML
    private TextField inputSellerName;
    @FXML
    private TextField inputSellerCNPJ;
    @FXML
    private TextField inputSellerWallet;
    @FXML
    private TableColumn<Product, String> columnProductName;
    @FXML
    private TextField inputProductName;
    @FXML
    private TextField inputProductPrice;
    @FXML
    private TextField inputProductBarcode;

    // BuySell
    @FXML
    private TextField inputBuySellClientCPF;
    @FXML
    private TextField inputBuySellSellerCNPJ;

    // Payment
    @FXML
    private ComboBox<Payment> selectPaymentMethod;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        // Verifica se é a tabela de clientes
        //if (tableClient) {}
        columnClientName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnClientCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnClientWallet.setCellValueFactory(new PropertyValueFactory<>("wallet"));

        // Verifica se é a tabela de vendedores
    /*if (tableSeller) {
      columnSellerName.setCellValueFactory(new PropertyValueFactory<>("name"));
      columnSellerCNPJ.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
      columnSellerWallet.setCellValueFactory(new PropertyValueFactory<>("wallet"));
    }*/

        // Verifica se é a tabela de produtos
    /*if (tableProduct) {
      columnProductName.setCellValueFactory(new PropertyValueFactory<>("name"));
      columnProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
      columnProductBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
    }*/
        update();

        tableClient.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                selecionada = (Buyer) newValue;

            }
        });
    }

    private void update() {
        tableClient.getItems().clear();

        for (Object item : buyersList) {
            tableClient.getItems().add((Buyer) item);
        }
    }

    private void cleanFields(String local){
        switch (local){
            case "Clientes":
                inputClientName.setText("");
                inputClientCPF.setText("");
                inputClientWallet.setText("");
                break;
            case "Vendedor":
                inputSellerName.setText("");
                inputSellerWallet.setText("");
                inputSellerCNPJ.setText("");

        }

    }

    // Handle Client
    @FXML
    public void handleSaveClient(ActionEvent event) {
        if ((inputClientName.getText() != null && !inputClientName.getText().isEmpty())) {
            if ((inputClientCPF.getText() != null && !inputClientCPF.getText().isEmpty())) {
                if ((inputClientWallet.getText() != null && !inputClientWallet.getText().isEmpty())) {
                    Buyer p = new Buyer(inputClientName.getText(), inputClientCPF.getText(), Double.parseDouble(inputClientWallet.getText()));
                    tableClient.getItems().add(p);
                    buyersList.add(p);
                }
            }
        }


        // Limpa os inputs
        cleanFields("Clientes");
    }

    @FXML
    public void handleEditClient(ActionEvent event) {
        Buyer clientTable = tableClient.getSelectionModel().getSelectedItem();

        if("Editar".equals(editClient.getText())){
            inputClientName.setText(clientTable.getName());
            inputClientCPF.setText(clientTable.getCpf());
            inputClientWallet.setText(String.valueOf(clientTable.getWallet()));

            saveClient.setDisable(true);
            deleteClient.setDisable(true);
            editClient.setText("Salvar");
        }else{
            clientTable.setName(inputClientName.getText());
            clientTable.setCpf(inputClientCPF.getText());
            clientTable.setWallet(Double.parseDouble(inputClientWallet.getText()));

            buyersList.set(tableClient.getSelectionModel().getSelectedIndex(), clientTable);


            update();
            saveClient.setDisable(false);
            deleteClient.setDisable(false);
            cleanFields("Clientes");
            editClient.setText("Editar");
        }


    }

    @FXML
    public void handleCancelClient(ActionEvent event) {
        // Limpa os inputs
        cleanFields("Clientes");
    }

    @FXML
    public void handleDeleteClient(ActionEvent event) {
        int index = tableClient.getSelectionModel().getSelectedIndex();
        buyersList.remove(index);
        update();

    }

    // Handle Seller
    @FXML
    public void handleSaveSeller(ActionEvent event) {
        if ((inputSellerName.getText() != null && !inputSellerName.getText().isEmpty())) {
            if ((inputSellerCNPJ.getText() != null && !inputSellerCNPJ.getText().isEmpty())) {
                if ((inputSellerWallet.getText() != null && !inputSellerWallet.getText().isEmpty())) {
                    tableSeller.getItems().add(new Seller(inputSellerName.getText(), inputSellerCNPJ.getText(), Double.parseDouble(inputSellerWallet.getText())));
                }
            }
        }

        // Limpa os inputs
        inputSellerName.setText("");
        inputSellerCNPJ.setText("");
        inputSellerWallet.setText("");
    }

    @FXML
    public void handleEditSeller(ActionEvent event) {
        System.out.println("Botão editar vendedor funcionando!");
    }

    @FXML
    public void handleCancelSeller(ActionEvent event) {
        // Limpa os inputs
        inputSellerName.setText("");
        inputSellerCNPJ.setText("");
        inputSellerWallet.setText("");
    }

    @FXML
    public void handleDeleteSeller(ActionEvent event) {
        System.out.println("Botão apagar vendedor funcionando!");
    }

    // Handle Product
    @FXML
    public void handleSaveProduct(ActionEvent event) {
        if ((inputProductName.getText() != null && !inputProductName.getText().isEmpty())) {
            if ((inputProductPrice.getText() != null && !inputProductPrice.getText().isEmpty())) {
                if ((inputProductBarcode.getText() != null && !inputProductBarcode.getText().isEmpty())) {
                    tableProduct.getItems().add(new Product(inputProductName.getText(), Double.parseDouble(inputProductPrice.getText()), inputProductBarcode.getText()));
                }
            }
        }

        // Limpa os inputs
        inputProductName.setText("");
        inputProductPrice.setText("");
        inputProductBarcode.setText("");
    }

    @FXML
    public void handleEditProduct(ActionEvent event) {
        System.out.println("Botão editar produto funcionando!");
    }

    @FXML
    public void handleCancelProduct(ActionEvent event) {
        // Limpa os inputs
        inputProductName.setText("");
        inputProductPrice.setText("");
        inputProductBarcode.setText("");
    }

    @FXML
    public void handleDeleteProduct(ActionEvent event) {
        System.out.println("Botão apagar produto funcionando!");
    }

    // Handle BuySell
    @FXML
    public void handleSaveBuySell(ActionEvent event) {
        System.out.println("Botão salvar venda funcionando!");
    }

    @FXML
    public void handleEditBuySell(ActionEvent event) {
        System.out.println("Botão editar venda funcionando!");
    }

    @FXML
    public void handleCancelBuySell(ActionEvent event) {
        // Limpa os inputs
        inputBuySellClientCPF.setText("");
        inputBuySellSellerCNPJ.setText("");
    }

    @FXML
    public void handleDeleteBuySell(ActionEvent event) {
        System.out.println("Botão apagar produto funcionando!");
    }

    // Payment Method
    @FXML
    public void handleSelectPaymentMethod(ActionEvent event) {
        System.out.print("\t1 - Pix\n\t2 - Débito\n\t3 - Crédito\n\t4 - Boleto\nSelecione a forma de pagamento: ");
    }
}
