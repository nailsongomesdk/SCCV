package main.app.sccv.model.payment;

public enum PaymentEnum implements PaymentInterface {
  PAYMENT1(1, "Pix"),
  PAYMENT2(2, "Débito"),
  PAYMENT3(3, "Crédito"),
  PAYMENT4(4, "Boleto");

  private final int PAYMENT_VALUE;
  private final Payment PAYMENT_NAME;

  private PaymentEnum(int value, Payment name) {
    this.PAYMENT_VALUE = value;
    this.PAYMENT_NAME = name;
  }

  public int getPaymentValue() {
    return PAYMENT_VALUE;
  }

  public Payment getPaymentName() {
    return PAYMENT_NAME;
  }

  public static PaymentEnum fromValue(int i) {
    for (PaymentEnum candidate : values()) {
      if (candidate.PAYMENT_VALUE == i) {
        return candidate;
      }
    }

    return null;
  }
}
