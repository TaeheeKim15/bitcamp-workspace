// 종합 정리 - 인스턴스 필드 초기화 적용
package com.eomcs.oop.ex03;

public class Exam0920 {

  static class Monitor {

    // 초기화 문장?
    // 변수를 선언할 때 값을 설정하는 것을 초기화 문장이라 부른다
    //
    int bright = 50;
    int contrast = 50;
    int widthRes = 1920;
    int heightRes = 1080;

    void display() {
      System.out.println("--------------");
      System.out.printf("밝기(%d)\n", this.bright);
      System.out.printf("명암(%d)\n", this.contrast);
      System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
      System.out.println("---------------");
    }
  }

  public static void main(String[] args) {
    // 모니터 인스턴스 생성
    Monitor m1 = new Monitor();

    // 인스턴스 필드의 값이 유효한 기본 값들로 미리 초기화되었기 때문에 바로 사용할 수 있다

    m1.display();

    // 물론 특정 속성의 값을 바꾼 후에 사용해도 된다
    m1.bright = 40;

    m1.display();
  }

}
