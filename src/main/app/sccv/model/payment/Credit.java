package main.app.sccv.model.payment;

import main.app.sccv.model.person.Buyer;
import main.app.sccv.model.person.Seller;

public class Credit extends Payment {
  public void paymentMethod(Buyer buyerWallet, Seller sellerWallet, double value) {
    setTax(5.99 / 100);
    super.paymentMethod(buyerWallet, sellerWallet, value + (value * getTax()));
  }
}
