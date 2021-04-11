package main.app.sccv.control;

import main.app.sccv.model.Product;
import main.app.sccv.model.person.Buyer;
import main.app.sccv.model.person.Seller;
import main.app.sccv.view.menu.Menu;

public class Search {
  public static Buyer searchingBuyer(String cpf) {
    for (Buyer buyer : Menu.buyersList) {
      if (cpf.equals(buyer.getCpf())) {
        return buyer;
      }
    }

    return null;
  }

  public static Seller searchingSeller(String cnpj) {
    for (Seller seller : Menu.sellersList) {
      if (cnpj.equals(seller.getCnpj())) {
        return seller;
      }
    }

    return null;
  }

  public static Product searchingProduct(String barcode) {
    for (Product produto : Menu.cartList) {
      if (barcode.equals(produto.getBarcode())) {
        return produto;
      }
    }

    return null;
  }
}
