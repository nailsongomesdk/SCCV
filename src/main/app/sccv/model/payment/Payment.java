package src.main.app.sccv.model.payment;

import src.main.app.sccv.model.person.Buyer;
import src.main.app.sccv.model.person.Seller;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Payment {
  private double tax;
  private LocalDate date;
  private LocalDate dueDate;

  public double getTax() {
    return tax;
  }

  public void setTax(double tax) {
    this.tax = tax;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  //  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

  //  Método para gerar data aleatória sem ordenação cronológica
  public LocalDate randomDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    long minimumDate = LocalDate.of(2021, 1, 1).toEpochDay();
    long maximumDate = LocalDate.of(2021, 12, 31).toEpochDay();
    long randomDate = ThreadLocalRandom.current().nextLong(minimumDate, maximumDate);

    date = LocalDate.ofEpochDay(randomDate);

    return date;
  }

  //  Método para verificar o vencimento do boleto
  public void dueDateMethod() {
    if (getDueDate().isBefore(LocalDate.now())) {
      System.out.println("Boleto vencido!");
    }
  }

  //  Método para realizar a transaçao da compra / venda
  public void paymentMethod(Buyer buyerWallet, Seller sellerWallet, double value) {
    double wallet = buyerWallet.getWallet();
    double balance = sellerWallet.getWallet();
    buyerWallet.setWallet(wallet - value);
    sellerWallet.setWallet(balance + value);

    setDate(LocalDate.now());
  }

  @Override
  public String toString() {
    return MessageFormat.format("\tData do pagamento: {0}\n\tData do vencimento: {1}\n", getDate(), getDueDate());
  }
}
