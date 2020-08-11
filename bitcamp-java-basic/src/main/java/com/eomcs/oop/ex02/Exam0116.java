package com.eomcs.oop.ex02;

import com.eomcs.oop.ex02.util.Score;

public class Exam0116 {


  public static void main(String[] args) {

    Score s1;
    s1 = new Score();
    // 덩어리로 묶지 않으면 메모리 주소를 전달할 수 없다
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 87;
    s1.compute();

    Score s2;
    s2 = new Score();
    // 덩어리로 묶지 않으면 메모리 주소를 전달할 수 없다
    s2.name = "임꺽정";
    s2.kor = 100;
    s2.eng = 90;
    s2.math = 87;
    s2.compute();
    // 둘 다 명시적 형변환을 해주거나 하나를 형변환 주어야 한다


    printScore(s1);
    System.out.println("------------");
    printScore(s2);

  }



  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d,%d,: %.1f\n",
        s.name, s.kor, s.eng, s.math, s.sum, s.average);

  }

}
