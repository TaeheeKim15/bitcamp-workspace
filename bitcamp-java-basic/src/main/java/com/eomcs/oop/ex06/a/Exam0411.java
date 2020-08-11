// 다형성 - 다형적 변수의 활용
package com.eomcs.oop.ex06.a;

public class Exam0411 {

  // Sedan과 Truck의 모델명과 cc를 출력하라!

  public static void printSedan(Sedan sedan) {
    System.out.printf("모델명: %s\n", sedan.model);
    System.out.printf("cc: %d\n", sedan.cc);
    System.out.println("-----------------");
  }

  public static void main(String[] args) {
Sedan car1 = new Sedan();
car1.model = "티코";
car1.cc = 800;

Sedan car2 = new Sedan();
car2.model = "타코";
car2.cc = 3000;

Truck car3 = new Truck();
car3.model = "타이탄2";
car3.cc = 10000;

printSedan(car1);
printSedan(car2);

// printSedan()의 파라미터는 Sedan 객체의 주소만 받을 수 있다.
// 그래서 Truck 객체를 전달할 수 없다
//printSedan(car2);

// Truck 인스턴스에서 model과 cc 값을 꺼내서 출력할 메서드를
// 따로 만들어야 한다.
  }

}
