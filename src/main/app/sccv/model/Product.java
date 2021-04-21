package main.app.sccv.model;

import java.text.MessageFormat;
import java.util.Objects;

public class Product {
  private String name;
  private double price;
  private String barcode;
  private String sellerCnpj;

  public Product(String name, double price, String barcode, String cnpj) {
    this.name = name;
    this.price = price;
    this.barcode = barcode;
    this.sellerCnpj = cnpj;
  }

  public String getSellerCnpj() {
    return sellerCnpj;
  }

  public void setSellerCnpj(String sellerCnpj) {
    this.sellerCnpj = sellerCnpj;
  }

  public Product() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }
    Product product = (Product) o;
    return barcode.equals(product.barcode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(barcode);
  }

  @Override
  public String toString() {
    return MessageFormat.format("\tProduto: {0}\n\tPreço: R${1}\n\tCódigo de barra: {2}\n", getName(), getPrice(), getBarcode());
  }
}
