package main.app.sccv.model.person;

import main.app.sccv.model.BuySell;
import main.app.sccv.model.payment.Payment;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Buyer extends Person {
  private String cpf;
  private List<BuySell> purchases = new ArrayList<>();
  private List<Payment> amountsPayable = new ArrayList<>();

  public Buyer() {}

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setPurchases(BuySell purchases) {
    this.purchases.add(purchases);
  }

  public void setAmountsPayable(Payment amountsPayable) {
    this.amountsPayable.add(amountsPayable);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }
    Buyer buyer = (Buyer) o;
    return cpf.equals(buyer.cpf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpf);
  }

  @Override
  public String toString() {
    return MessageFormat.format("\tComprador: {0}\n\tCPF: {1}\n\tCarteira: R${2}\n", getName(), getCpf(), getWallet());
  }
}
