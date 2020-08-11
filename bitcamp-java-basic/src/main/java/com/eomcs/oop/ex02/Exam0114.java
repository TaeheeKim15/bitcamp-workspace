package com.eomcs.oop.ex02;

public class Exam0114 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    static void computeScore(Score s) {
      s.sum = s.kor + s.eng + s.math;
      s.average = s.sum / 3f;
    }
  }

  public static void main(String[] args) {

    Score s1;
    s1 = new Score();
    // 덩어리로 묶지 않으면 메모리 주소를 전달할 수 없다
    s1.name = "임꺽정";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 87;
    Score.computeScore(s1);

Score s2;
    s2 = new Score();
    // 덩어리로 묶지 않으면 메모리 주소를 전달할 수 없다
    s2.name = "임꺽정";
    s2.kor = 100;
    s2.eng = 90;
    s2.math = 87;
    Score.computeScore(s2);
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
