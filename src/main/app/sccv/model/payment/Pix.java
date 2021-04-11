package src.main.app.sccv.model.payment;

import src.main.app.sccv.model.person.Buyer;
import src.main.app.sccv.model.person.Seller;

public class Pix extends Payment {
  public void paymentMethod(Buyer buyerWallet, Seller sellerWallet, double value) {
    super.paymentMethod(buyerWallet, sellerWallet, value);
  }
}
