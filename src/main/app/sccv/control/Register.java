package src.main.app.sccv.control;

import src.main.app.sccv.model.BuySell;
import src.main.app.sccv.model.Product;
import src.main.app.sccv.model.person.Buyer;
import src.main.app.sccv.model.person.Seller;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Scanner;

public class Register {

  public static Buyer buyerRegistration() {
    Buyer comprador = new Buyer();
    Scanner entry = new Scanner(System.in);

    System.out.println("CADASTRAR COMPRADOR");
    System.out.print("Digite seu nome: ");
    comprador.setName(entry.nextLine());

    System.out.print("Digite seu CPF (somente números): ");
    try {
      MaskFormatter mask = new MaskFormatter("###.###.###-##");
      mask.setValueContainsLiteralCharacters(false);
      comprador.setCpf(mask.valueToString(entry.nextLine()));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    System.out.print("Valor na carteira (ex: 50.35): R$");
    comprador.setWallet(Double.parseDouble(entry.nextLine()));

    System.out.println("Cliente cadastrado com sucesso!");

    return comprador;
  }

  public static Seller sellerRegistration() {
    Seller vendedor = new Seller();
    Scanner entry = new Scanner(System.in);

    System.out.println("CADASTRAR VENDEDOR");
    System.out.print("Digite seu nome: ");
    vendedor.setName(entry.nextLine());
    System.out.print("Digite seu CNPJ (somente números): ");

    try {
      MaskFormatter mask = new MaskFormatter("###.###.###/####-##");
      mask.setValueContainsLiteralCharacters(false);
      vendedor.setCnpj(mask.valueToString(entry.nextLine()));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    System.out.print("Valor em caixa (ex: 50.35): R$");
    vendedor.setWallet(Double.parseDouble(entry.nextLine()));

    System.out.println("Vendedor cadastrado com sucesso!");

    return vendedor;
  }

  public static Product productRegistration() {
    Product produto = new Product();
    Scanner entry = new Scanner(System.in);

    System.out.println("CADASTRAR PRODUTO");
    System.out.print("Nome do produto: ");
    produto.setName(entry.nextLine());
    System.out.print("Preço (ex: 50.35): R$");
    produto.setPrice(Double.parseDouble(entry.nextLine()));

    try {
      MaskFormatter mask = new MaskFormatter("# #### #### #");
      mask.setValueContainsLiteralCharacters(false);
      System.out.print("Código de barra (10 digitos): ");
      produto.setBarcode(mask.valueToString((entry.nextLine())));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    System.out.println("Produto adicionado com sucesso!");

    return produto;
  }

  // public static BuySell buySellRegistration() {}
}
