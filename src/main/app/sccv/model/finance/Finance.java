package main.app.sccv.model.finance;

public enum Finance implements FinanceInterface {
  MES01(1, "Janeiro"),
  MES02(2, "Fevereiro"),
  MES03(3, "Março");

  private final int MONTH_VALUE;
  private final String MONTH_NAME;

  private Finance(int value, String name) {
    this.MONTH_VALUE = value;
    this.MONTH_NAME = name;
  }

  public int getValue() {
    return MONTH_VALUE;
  }

  public String getName() {
    return MONTH_NAME;
  }

  public static Finance fromValue(int i) {
    for (Finance candidate : values()) {
      if (candidate.MONTH_VALUE == i) {
        return candidate;
      }
    }

    return null;
  }
}