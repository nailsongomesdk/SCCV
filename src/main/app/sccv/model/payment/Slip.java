package main.app.sccv.model.payment;

import main.app.sccv.model.person.Buyer;
import main.app.sccv.model.person.Seller;

import java.time.LocalDate;

public class Slip extends Payment {
  public void paymentMethod(Buyer buyerWallet, Seller sellerWallet, double value) {
    setTax(9.99 / 100);
    super.paymentMethod(buyerWallet, sellerWallet, value + (value * getTax()));

    setDate(LocalDate.now());
    setDueDate(LocalDate.now().plusDays(7));
  }
}
