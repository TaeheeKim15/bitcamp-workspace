// 캡슐화(encapsulation) - 응용
package com.eomcs.oop.ex07.b;

import com.eomcs.oop.ex07.b.sub.C;

public class Exam0220 extends C {

  public static void main(String[] args) {
//    인테리어업자 builder = new 인테리어업자();
//    김가네 factory = builder.build();
//    김밥 obj = factory.create("참치");

    //Car c1 = new Car(); // 컴파일 오류!
    // 생성자가 private이기 때문에 다른 클래스에서 호출할 수 없다.
    // 따라서 인스턴스를 생성할 수 없다.
    //
    // 그럼 왜 생성자를 private으로 만들었는가?
    // => 개발자가 직접 인스턴스를 생성하면 너무 복잡하니,
    //    다른 메서드를 통해 인스턴스를 생성하라는 의미다!
    Car c2 = Car.create("티코");
    //아~ Car인스턴스 생성과정이 복잡해서 이렇게 한 거 구나
    System.out.printf("%s,%s,%d,%d\n",
        c2.model, c2.maker, c2.cc, c2.valve);

  }
}







