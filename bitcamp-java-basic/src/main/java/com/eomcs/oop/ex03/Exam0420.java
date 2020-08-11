package com.eomcs.oop.ex03;

public class Exam0420 {

  static class SmartPhone{

    int volume;
    int bright;
    int contrust;

    // 다음과 같이 기본 생성자를 직접 정의할 수 있다
    public SmartPhone() {  // 여기 void 붙이면 일반 메소드 되버림
      System.out.println("SmartPhone() 생성자 호출됨!");
    }
  }
  public static void main(String[] args) {
    SmartPhone obj1 = new SmartPhone();
  }
}
