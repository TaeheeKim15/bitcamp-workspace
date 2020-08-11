// 스태틱 초기화 블록 - 변수 초기화 문장
package com.eomcs.oop.ex03;

public class Exam0680 {


  public static class A {
    static int a = 100;
    static {
      a = 200;
      System.out.println("static {} 실행");
    }


    static {
      b = 400;
    }

    static int b = 300;

    // 변수 초기화 문장이 있을 때
    // - 일단 모든 스태틱 필드를 먼저 만든다
    // - 스태틱 변수 초기화 문장을 스태틱 블록으로 변경한 다음에
    //   모든 스태틱 블록을 순서대로 한 스태틱 블록에 합친다
    // - 스태틱 변수 초기화 문장과 스태틱 블록을 구분하지 않고
    //   선언된 순서대로 하나의 스태틱 블록에 합친다
    // - 위의 문장은 다음 문장으로 바뀐다
    //
    // static int a;
    // static {
    //      a = 100;
    //      a = 200;
    //      System.out.println("static {} 실행");
    //      b = 400;
    //      b = 300;
    // }
    // - 바이트 코드를 확인해 보자
  }

  public static void main(String[] args) {

    System.out.println(A.a);
    System.out.println(A.b);
  }
}
