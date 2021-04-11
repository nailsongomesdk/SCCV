package main.app.sccv.model.person;

public class Person {
  private String name;
  private double wallet;

  //  construtor de pessoa
  public Person(String name, double wallet) {
    this.name = name;
    this.wallet = wallet;
  }

  public Person() {}

  //  getters e setters
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getWallet() {
    return wallet;
  }

  public void setWallet(double wallet) {
    this.wallet = wallet;
  }
}


