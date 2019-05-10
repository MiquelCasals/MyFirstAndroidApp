package es.covalco.myapplication;

public class Calculator implements ICalculator {

  private int num1;
  private int num2;

  public Calculator() {
  }
  public Calculator(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  @Override
  public int add() {
    return(num1 + num2);
  }

  @Override
  public int substract() {
    return(num1 - num2);
  }

  @Override
  public int multiply() {
    return (num1 * num2);
  }

  @Override
  public int divide() {
    int result = 0;
    if (num2 != 0) {
      result = num1 / num2;
    }
    return result;
  }
}
