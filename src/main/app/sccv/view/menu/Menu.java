package main.app.sccv.view.menu;

import main.app.sccv.control.Register;
import main.app.sccv.control.Search;
import main.app.sccv.model.BuySell;
import main.app.sccv.model.Product;
import main.app.sccv.model.payment.*;
import main.app.sccv.model.person.Buyer;
import main.app.sccv.model.person.Seller;

import javax.swing.text.MaskFormatter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
  public static List<Seller> sellersList = new ArrayList<>();
  public static List<Buyer> buyersList = new ArrayList<>();
  public static List<Product> cartList = new ArrayList<>();

  public static void menu() {
    System.out.println("SISVENDA - Sistema de cadastro de vendas");
    System.out.print("\t1 - Cadastrar vendedor\n\t2 - Cadastrar cliente\n\t3 - Cadastrar produto\n\t4 - Imprimir dados de um vendedor\n\t5 - Imprimir dados de um comprador\n\t6 - Criar uma venda\n\t7 - Sair do sistema\n");
    System.out.print("Selecione uma das opções: ");

    selection();
  }

  public static void selection() {
    Scanner entry = new Scanner(System.in);

    switch (entry.nextInt()) {
      case 1:
        sellersList.add(Register.sellerRegistration());
        menu();
        break;

      case 2:
        buyersList.add(Register.buyerRegistration());
        menu();
        break;

      case 3:
        Seller vendedorProduto = new Seller();
        System.out.print("Digite o CNPJ do vendedor ao qual deseja cadastrar o produto: ");

        try {
          MaskFormatter mask = new MaskFormatter("###.###.###/####-##");
          mask.setValueContainsLiteralCharacters(false);
          String cnpjDigitado = mask.valueToString(entry.next());

          if (sellersList.isEmpty() || ! sellersList.contains(Search.searchingSeller(cnpjDigitado))) {
            System.err.println("Não é possível cadastrar o produto. Vendedor inexistente.");
            System.err.flush();
          } else {
            vendedorProduto = Search.searchingSeller(cnpjDigitado);
            assert vendedorProduto != null;
            //vendedorProduto.addProductCatalogue();
          }
        } catch (ParseException e) {
          e.printStackTrace();
        }

        menu();
        break;

      case 4:
        System.out.print("Informe o CNPJ: ");

        try {
          MaskFormatter mask = new MaskFormatter("###.###.###/####-##");
          mask.setValueContainsLiteralCharacters(false);
          String cnpjDigitado = mask.valueToString(entry.next());

          if (sellersList.isEmpty() || ! sellersList.contains(Search.searchingSeller(cnpjDigitado))) {
            System.err.println("Vendedor não encontrado. Verifique se o CNPJ está correto.");
            System.err.flush();
          } else {
            System.out.println(Search.searchingSeller(cnpjDigitado));
          }
        } catch (ParseException e) {
          e.printStackTrace();
        }

        menu();
        break;

      case 5:
        System.out.print("Informe o CPF: ");

        try {
          MaskFormatter mask = new MaskFormatter("###.###.###-##");
          mask.setValueContainsLiteralCharacters(false);
          String cpfDigitado = mask.valueToString(entry.next());

          if (buyersList.isEmpty() || ! buyersList.contains(Search.searchingBuyer(cpfDigitado))) {
            System.err.println("Cliente não encontrado. Verifique se o CPF está correto.");
            System.err.flush();
          } else {
            System.out.print(Search.searchingBuyer(cpfDigitado));
          }
        } catch (ParseException e) {
          e.printStackTrace();
        }

        menu();
        break;

      case 6:
        BuySell venda = new BuySell();
        Buyer cliente = null;
        Seller vendedor = null;

        try {
          MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
          MaskFormatter maskCnpj = new MaskFormatter("###.###.###/####-##");
          MaskFormatter maskCodigoBarra = new MaskFormatter("# #### #### #");
          maskCpf.setValueContainsLiteralCharacters(false);
          maskCnpj.setValueContainsLiteralCharacters(false);
          maskCodigoBarra.setValueContainsLiteralCharacters(false);
          boolean isAdd = false;

          System.out.print("Digite o CPF do cliente: ");
          String cpfComprador = maskCpf.valueToString(entry.next());
          if (buyersList.isEmpty() || ! buyersList.contains(Search.searchingBuyer(cpfComprador))) {
            System.err.println("CPF inválido ou não existe no cadastro!");
            break;
          }

          System.out.print("Digite o CNPJ do Vendedor: ");
          String cnpjVendedor = maskCnpj.valueToString(entry.next());
          if (sellersList.isEmpty() || ! sellersList.contains(Search.searchingSeller(cnpjVendedor))) {
            System.err.println("CNPJ inválido ou não existe no cadastro!");
            break;
          }

          venda.setCpfBuyer(cpfComprador);
          venda.setCnpjSeller(cnpjVendedor);

          cliente = Search.searchingBuyer(cpfComprador);
          assert cliente != null;

          vendedor = Search.searchingSeller(cnpjVendedor);
          assert vendedor != null;
          cartList = vendedor.getProductCatalogue();

          do {
            System.out.print("Digite o codigo de barras do produto: ");
            String codigoBarra = maskCodigoBarra.valueToString(entry.next());

            if (! cartList.contains(Search.searchingProduct(codigoBarra))) {
              System.err.println("Produto indisponivel!");
              System.err.flush();
            } else {
              venda.addProduct(Search.searchingProduct(codigoBarra));
            }

            System.out.print("Gostaria de adicionar outro? (S/N): ");
            String auth = entry.next();

            if ("s".equalsIgnoreCase(auth)) {
              isAdd = true;
            } else {
              isAdd = false;
            }
          } while (isAdd);

          System.out.print("\t1 - Pix\n\t2 - Débito\n\t3 - Crédito\n\t4 - Boleto\nSelecione a forma de pagamento: ");
          switch (entry.next()) {
            case "1":
              Payment pagamentoViaPix = new Pix();
              pagamentoViaPix.paymentMethod(cliente, vendedor, venda.totallySell());
              venda.setPayment(pagamentoViaPix);
              cliente.setAmountsPayable(pagamentoViaPix);
              vendedor.setAmountsReceivables(pagamentoViaPix);
              System.out.println("Pagamento efetuado com sucesso!");
              break;

            case "2":
              Payment pagamentoViaDebito = new Debit();
              pagamentoViaDebito.paymentMethod(cliente, vendedor, venda.totallySell());
              venda.setPayment(pagamentoViaDebito);
              cliente.setAmountsPayable(pagamentoViaDebito);
              vendedor.setAmountsReceivables(pagamentoViaDebito);
              System.out.println("Pagamento efetuado com sucesso!");
              break;

            case "3":
              Payment pagamentoViaCredito = new Credit();
              pagamentoViaCredito.paymentMethod(cliente, vendedor, venda.totallySell());
              venda.setPayment(pagamentoViaCredito);
              cliente.setAmountsPayable(pagamentoViaCredito);
              vendedor.setAmountsReceivables(pagamentoViaCredito);
              System.out.println("Pagamento efetuado com sucesso!");
              break;

            case "4":
              Payment pagamentoViaBoleto = new Slip();
              pagamentoViaBoleto.paymentMethod(cliente, vendedor, venda.totallySell());
              venda.setPayment(pagamentoViaBoleto);
              cliente.setAmountsPayable(pagamentoViaBoleto);
              vendedor.setAmountsReceivables(pagamentoViaBoleto);
              System.out.println("Pagamento efetuado com sucesso!");
              break;

            default:
              System.err.println("Opção de pagamento indisponível!");
              break;
          }
        } catch (ParseException e) {
          e.printStackTrace();
        }

        assert cliente != null;
        cliente.setPurchases(venda);
        vendedor.setSalesMade(venda);

        System.out.println("CUPOM FISCAl");
        System.out.println(venda);
        break;

      case 7:
        try {
          System.out.println("Encerrando os processos...");
          Thread.sleep(3000);

          if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
          } else {
            Runtime.getRuntime().exec("clear");
          }
        } catch (InterruptedException | IOException e) {
          e.printStackTrace();
        }
        break;

      default:
        System.err.println("Opção inválida, tente novamente.");
        menu();
    }
  }
}
