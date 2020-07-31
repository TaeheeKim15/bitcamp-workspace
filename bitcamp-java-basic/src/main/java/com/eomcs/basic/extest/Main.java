package com.eomcs.basic.extest;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    Scanner keyScan = new Scanner(System.in);

    int A = keyScan.nextInt();

    int B = keyScan.nextInt();

    if (-10000 <= A && B <= 10000) {
      if (A > B)
        System.out.println(">");
        else if (A < B)
          System.out.println("<");
          else
            System.out.println("==");



    }


    keyScan.close();
  }
}