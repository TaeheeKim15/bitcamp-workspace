package com.eomcs.oop.ex02;

import com.eomcs.oop.ex02.util.Score2;

public class Exam0117 {


  public static void main(String[] args) {

    Score2 s1 = new Score2();
    s1 = new Score2();
    // 덩어리로 묶지 않으면 메모리 주소를 전달할 수 없다

    s1.init("홍길동", 100, 90, 87);
    s1.compute();

    Score2 s2 = new Score2();
    // 덩어리로 묶지 않으면 메모리 주소를 전달할 수 없다
    s2.init("임꺽정", 90, 100, 100);
    s2.compute();
    // 둘 다 명시적 형변환을 해주거나 하나를 형변환 주어야 한다


    printScore(s1);
    System.out.println("------------");
    printScore(s2);

  }



  static void printScore(Score2 s) {
    System.out.printf("%s: %d, %d, %d,%d,: %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.average);

  }

}
