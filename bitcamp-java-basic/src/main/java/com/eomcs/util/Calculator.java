package com.eomcs.util;

// 독립했기 때문에 static은 빼자
public class Calculator {

  public int result = 0;

  public  void plus(int value) {
    this.result += value;
  }

  public  void minus(int value) {
    result -= value;
  }

  public  void multiple(int value) {
    result *= value;
  }

  public void divide(int value) {
    result /= value;
  }

}
