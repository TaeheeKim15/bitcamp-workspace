package com.eomcs.basic.ex07;

// 메서드 : 개념 및 기본 문법
//
public class Exam0220 {

  static void hello(String name, int age) {
    System.out.printf("%d살 %s님 반갑습니다. \n", age, name);
  }

  public static void main(String[] args) {

    System.out.println("main()11111");

    hello("홍길동", 20);

    System.out.println("main()22222");

    hello("임꺽정", 30);

    System.out.println("main()33333");

    hello("유관순", 16);

    System.out.println("main()44444");
    }
  }

//아규먼트(argument)
//- 메서드를 호출할 때 넘겨주는 값
//- 예) hello("홍길동", 20);
//"홍길동", 20 이 아규먼트이다.
//
//파라미터(parameter)
//- 아규먼트를 받는 변수
//- 예) void hello(String name, int age) {...}
//name과 age 변수가 파라미터이다.
//
//현장에서는 "아규먼트"와 "파라미터"를 구분하지 않고 사용한다.
