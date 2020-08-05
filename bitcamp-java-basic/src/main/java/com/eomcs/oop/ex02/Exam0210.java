package com.eomcs.oop.ex02;

import com.eomcs.util.Calculator;

public class Exam0210 {




  public static void main(String[] args) {
    // 2 + 3 - 1 * 7 / 3 = 9

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();


    Calculator.plus(c1, 2);
    Calculator.plus(3);
    Calculator.minus(1);
    Calculator.multiple(7);
    Calculator.divide(3);

    printResult(Calculator.result);


  }

  static void printResult(int value) {
    System.out.println("*****************");
    System.out.printf("===> 결과 = %d\n", value);
    System.out.println("*****************");
  }



}
