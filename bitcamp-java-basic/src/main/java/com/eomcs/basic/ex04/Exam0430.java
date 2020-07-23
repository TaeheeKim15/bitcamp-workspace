package com.eomcs.basic.ex04;

public class Exam0430 {
  public static void main(String[] args) {
    char c;
    
    c = 0;
    c = 65535;
    //c = -1;
    //c = 65536;
    
    c = 65;
    c = 0x42;
    c = 0b01000011;
    System.out.println(c);
    
    short s = 65;
    System.out.println(s);
    
    c = '헐'; // '' 연산자는 문자의 유니코드 값을 리턴한다.
    System.out.println(c);
    // 메모리에 문자를 저장한다(X)
    // 메모리에 문자에 해당하는 문자코드를 저장한다(O)
    // 문자 코드는 다양하지만, 자바는 유니코드(2바이트)
    
    int i = '헐';
    System.out.println(i);
        
    // 문자 코드는 정수 값이다
    for (int x = 65; x < 80; x++) {
      System.out.println((char)x);
    }
    
    boolean b1, b2;
    b1 = true;
    b2 = false;
    
    System.out.println(b1);
    System.out.println(b2);
    
    
    // 논리 값은 정수로 다룰 수 없다
    //i = b1;
    //i = b2;
    //b1 = 1;
    
    
  }
}
