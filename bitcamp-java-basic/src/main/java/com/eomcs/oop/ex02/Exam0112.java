package com.eomcs.oop.ex02;


public class Exam0112 {



  public static void main(String[] args) {

    Score s1 = new Score();
    // 덩어리로 묶지 않으면 메모리 주소를 전달할 수 없다
    s1.name = "임꺽정";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 87;
    s1.sum = s1.kor + s1.eng + s1.math;
    s1.aver = s1.sum / 3f;


    Score s2 = new Score();
    // 덩어리로 묶지 않으면 메모리 주소를 전달할 수 없다
    s2.name = "임꺽정";
    s2.kor = 100;
    s2.eng = 90;
    s2.math = 87;
    s2.sum = s2.kor + s2.eng + s2.math;
    s2.aver = s2.sum / 3f;
    // 둘 다 명시적 형변환을 해주거나 하나를 형변환 주어야 한다


    printScore(s1);
    System.out.println("------------");
    printScore(s2);

  }

  static void printScore(String name, int kor, int eng, int math, int sum, float aver) {
    System.out.printf("%s: %d, %d, %d,%d,: %.1f\n",
        s1.name, s.kor, s.eng, s.math, s.sum, s.aver);

  }

}
