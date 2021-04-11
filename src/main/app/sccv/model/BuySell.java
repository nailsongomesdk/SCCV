package src.main.app.sccv.model;

import src.main.app.sccv.model.payment.Payment;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BuySell {
  private static long sequence = 1;
  private long id;
  private String cpfBuyer;
  private String cnpjSeller;
  private List<Product> itens = new ArrayList<>();
  private Payment payment = new Payment();

  public BuySell(String cpfBuyer, String cnpjSeller, List<Product> itens, Payment payment) {
    this.cpfBuyer = cpfBuyer;
    this.cnpjSeller = cnpjSeller;
    this.itens = itens;
    this.payment = payment;
    id = sequence++;
  }

  public BuySell() {}

  public void setCpfBuyer(String cpfBuyer) {
    this.cpfBuyer = cpfBuyer;
  }

  public void setCnpjSeller(String cnpjSeller) {
    this.cnpjSeller = cnpjSeller;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  public void addProduct(Product product) {
    itens.add(product);
    System.out.println("Produto adicionado ao carrinho!");
  }

  public List<Product> getItens() {
    return itens;
  }

  public double totallySell() {
    double value = 0;

    for (Product item : itens) {
      value += item.getPrice();
    }

    return value;
  }

  public String list() {
    StringBuilder list = new StringBuilder("LISTA DE PRODUTOS DA VENDA:");

    if (! itens.isEmpty()) {
      for (Product item : itens) {
        list.append("\t\n").append(item);
      }
    }

    return list.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }
    BuySell buySell = (BuySell) o;
    return id == buySell.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return MessageFormat.format("\tCodigo da venda: {0}\n\tCPF do comprador: {1}\n\tCNPJ do vendedor: {2}\n\tForma de Pagamento:\n{3}\n{4}\t\nValor total da venda: R${5}", this.id, this.cpfBuyer, this.cnpjSeller, payment, list(), totallySell());
  }
}
