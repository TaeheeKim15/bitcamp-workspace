package com.eomcs.oop.ex04;

import java.util.Calendar;
import java.util.Date;

public class Exam0110 {
  public static void main(String[] args) throws Exception{

    String s1 = null; // = new String(); <- 빈 문자열이란 소리로 null과 다름
    System.out.println("=>" + s1);

    String s2 = new String("Hello");
    System.out.println("=>" + s2);

    char[] chars = new char[] {'H', 'e', 'l', 'l', 'o','2'};
    String s3 = new String(chars);
    System.out.println("=>" + s3);

    byte[] bytes = new byte[] {
        0x41, // A
        0x42, // B
        (byte)0xEA, // 가
        (byte)0xB0,
        (byte)0x80,
        (byte)0xEA, // 나
        (byte)0xB0,
        (byte)0x81
    };
    String s4 = new String(bytes, "UTF-8");
    System.out.println("=>" + s4);

    byte[] bytes2 = new byte[] {
        0x41, // A
        0x42, // B
        (byte)0xB0,// 가 => AC00
        (byte)0xA1,
        (byte)0xB0,// 각 ==> AC01
        (byte)0xA2,
        (byte)0xB6,// 똘 (EUC-KR)
        (byte)0xCA,
        (byte)0x8C,// 똠( MS949/ CP949)
        (byte)0x63,
        (byte)0xB6,// 똥 (EUC-KR)
        (byte)0xCB

    };
    String s5 = new String(bytes2, "MS949"); // MS949(11172자) = EUC-KR(2350) + x
    System.out.println("=>" + s5);

    Date d1 = new Date();// 실행하는 시점의 날짜와 시분초로 초기화한다
    System.out.println(d1.toString());
    System.out.println(d1); //d1.toString
    // 아규먼트가 primitive type이나 String 타입이 아니면
    // 인스턴스에 대해 toString()을 호출하여 그 리턴 값을 출력한다
    // 자바에 모든 클래스에서 toString을 호출할 수 있다

    int[] arr = new int[] {100, 200, 300};
    System.out.println(arr.toString());
    System.out.println(arr); // arr.toString

    int a = 100;
    System.out.println(a);

    Date d2 = new Date(100000);
    System.out.println(d2);

    Date d3 = new Date(120, 8, 10);
    System.out.println(d3);

    // 클래스 중에서는 생성자를 공개하지 않은 경우가 있다
    // 이런 클래스의 인스턴스를 만들려면
    // 보통 다음 2가지 방법을 사용한다
    // 1) 첫번째 다른 클래스의 도움을 받는다
    // 2) 해당 클래스에서 제공하는 클래스(스태틱) 메서드를 사용한다
    //
    //Calendar c1 = new Calendar();
    Calendar  c1 = Calendar.getInstance();
    System.out.println(c1);//c1의 주소가 들어가 있다
    System.out.println(c1.toString());

    Car car1 = new Car();
    Car car2 = new Car();
    System.out.println(car1 == car2);
    car1.model = "티코";
    car2.cc = 980;
    car1.model = "소나타";
    car2.cc = 1980;
    System.out.println(car1.model);
    System.out.println(car2.model);

    Car2 car3 = Car2.getInstance();
    Car2 car4 = Car2.getInstance();
    System.out.println(car3 == car4);
    car3.model = "비트카";
    System.out.println(car4.model);
  }
}
class Car {
  String model;
  int cc;
}

class Car2 {
  String model;
  int cc;
  static Car2 obj;

  private Car2() {}

  static Car2 getInstance() {
    // 보통 생성자를 private으로 막는 경우는
    // 인스턴스를 한 개만 생성하도록 제안하고 싶을 때 주로 사용한다.
    if (obj == null) {
      obj = new Car2();
    }
    return new Car2();
  }
}

//비트 암호
//문자 ---> 암호
//A   ---> 1
//B   ---> 2
//c   ---> 3
//가  ---> 100
//각  ---> 101

// 다음 암호를 원래 문자로 표현하시오
// 1 --->
// 5 --->


















