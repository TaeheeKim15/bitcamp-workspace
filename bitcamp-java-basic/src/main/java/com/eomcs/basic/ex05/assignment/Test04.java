package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

//# 과제4 
//- 다음 int 변수에 들어있는 값을
//  각 자릿수의 10진수 값을 역순으로 출력하라
//실행 예)
//값: 23459876
//6
//7
//8
//9
//5
//4
//3
//2
public class Test04 {

  public static void main(String[] args) {
    int value = 23459876; 
    System.out.println(Integer.toBinaryString(value));
    // 0000 0001_0110 0101_1111 1000_0010 0100
    // 165F824
    
    // 코드를 완성하시오!
    System.out.println(value % 10);
    value = value / 10; // = 23456987
    
    System.out.println(value % 10);
    value = value / 10; // = 2345698
    
    System.out.println(value % 10);
    value = value / 10; // = 234569
    
    System.out.println(value % 10);
    value = value / 10; // = 23456
    
    System.out.println(value % 10);
    value = value / 10; // = 2345
    
    System.out.println(value % 10);
    value = value / 10; // = 234
    
    System.out.println(value % 10);
    value = value / 10; // = 23
    
    System.out.println(value % 10);
    value = value / 10; // = 2
    
    System.out.println("---------------------------");
    
    int value1 = 23459876; 
    
    while (value1 > 0) {
      System.out.println(value1 % 10);
      value1 = value1 / 10; // = 2345987
    }
    
    
    
    
    
    
    
  }
}    








    /* 코드를 완성하시오!
    int a, b, c, d, e, f, g;
    
    a = (((value >> 24) & 0xff) * 16 * 16 * 16 * 16 * 16 * 16);
    b = (((value >> 20) & 0x0f) * 16 * 16 * 16 * 16 * 16);
    c = (((value >> 16) & 0x0f) * 16 * 16 * 16 * 16);
    d = (((value >> 12) & 0x0f) * 16 * 16 * 16);
    e = (((value >> 8) & 0x0f) * 16 * 16);
    f = (((value >> 4) & 0x0f) * 16);
    g = ((value & 0xffffff));
    
    System.out.println(g);
   */


//440 & 연산과 비트 연산 활용할 것

//165F824







