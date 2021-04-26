package main.app.sccv.model.payment;

public enum PaymentEnum implements PaymentInterface {
  PIX_PAYMENT(1, "Pix"),
  DEBIT_PAYMENT(2, "Debit"),
  CREDIT_PAYMENT(3, "Credit"),
  SLIP_PAYMENT(4, "Slip");

  private final int PAYMENT_ID;
  private final String PAYMENT_TYPE;

  PaymentEnum(int value, String type) {
    this.PAYMENT_ID = value;
    this.PAYMENT_TYPE = type;
  }

  public int getPaymentValue() {
    return PAYMENT_ID;
  }

  public String getPaymentType() {
    return PAYMENT_TYPE;
  }

  public static PaymentEnum fromValue(int i) {
    for (PaymentEnum payment : values()) {
      if (payment.PAYMENT_ID == i) {
        return payment;
      }
    }

    return null;
  }
}
