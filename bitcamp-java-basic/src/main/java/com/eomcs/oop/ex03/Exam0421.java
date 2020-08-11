package com.eomcs.oop.ex03;

public class Exam0421 {

  static class SmartPhone{

    int volume;
    int bright;
    int contrust;

    // 생성자가 한 개라도 있으면 기본 생성자가 자동으로 생성되지 않는다
    public SmartPhone(int a) {  // 여기 void 붙이면 일반 메소드 되버림
      System.out.println("SmartPhone() 생성자 호출됨!");
    }
  }
  public static void main(String[] args) {
    //SmartPhone obj1 = new SmartPhone();
    SmartPhone obj1 = new SmartPhone(100);
    //SmartPhone obj1 = new SmartPhone((float)3.14);
  }
}
