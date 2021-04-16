package main.app.sccv.model.person;

import main.app.sccv.control.Register;
import main.app.sccv.model.BuySell;
import main.app.sccv.model.Product;
import main.app.sccv.model.payment.Payment;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Seller extends Person {
  private String cnpj;
  private List<BuySell> salesMade = new ArrayList<>();
  private List<Payment> amountsReceivables = new ArrayList<>();
  private List<Product> productCatalogue = new ArrayList<>();

  public Seller() {}

  public Seller(String name, String cnpj, double wallet) {
    super(name, wallet);
    this.cnpj = cnpj;
  }

  public Seller(Seller sellerTable) {
    super(sellerTable.getName(), sellerTable.getWallet());
    this.cnpj = sellerTable.getCnpj();
  }


  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public void setSalesMade(BuySell salesMade) {
    this.salesMade.add(salesMade);
  }

  public void setAmountsReceivables(Payment amountsReceivables) {
    this.amountsReceivables.add(amountsReceivables);
  }

  public List<Product> getProductCatalogue() {
    return productCatalogue;
  }

  public void addProductCatalogue() {
    productCatalogue.add(Register.productRegistration());
  }

  public String list() {
    StringBuilder list = new StringBuilder();

    for (Object item : productCatalogue) {
      list.append("\t\n").append(item);
    }

    return list.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }
    Seller seller = (Seller) o;
    return cnpj.equals(seller.cnpj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cnpj);
  }

  @Override
  public String toString() {
    return MessageFormat.format("\tVendedor: {0}\n\tCNPJ: {1}\n\tCarteira: R${2} \nCATALOGO DE PRODUTOS: {3}", getName(), getCnpj(), getWallet(), list());
  }
}
