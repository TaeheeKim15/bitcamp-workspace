package com.eomcs.oop.ex03;

public class Exam0130 {
  // 스태틱 변수(static field = class variable)
  static class A {
    static int v1;
    static boolean v2;
  }
public static void main(String[] args) {

  A obj1 = new A();
  A obj2 = new A();

  //레퍼런스.변수명 = 100;
  // - 레퍼런스 다음에 지정한 변수가 인스턴스 변수가 아니라
  // - 클래스 변수라면 컴파일러가 컴파일하는과정에서 정확하게
  //   클래스 변수를 가리키도록 기계어로 바꾼다
  // - 즉, 개발자가 래퍼런스를 통해 클래스 변수를 지정하더라도
  //   컴파일러가 클래스 변수로 인식하여 클래스 변수를 사용하는 코드로 변환한다.
  obj1.v1 = 100; // A.v1 = 100;
  obj2.v1 = 200; // A.v1 = 200;

  A.v1 = 300;



  System.out.println(obj1.v1);
  System.out.println(obj2.v1);
  System.out.print(A.v1);
}
}
