// 종합 정리 - 생성자에서 다른 생성자 호출하기 : this()
package com.eomcs.oop.ex03;

public class Exam0940 {

  static class Monitor {

    int bright;
    int contrast;
    int widthRes;
    int heightRes = 1080;

    Monitor() {
      // 다른 생성자를 호출할 수 있다.
      // 단, 첫 문장으로 와야 한다
      this(50, 50, 2560, 1200);
      System.out.println("Monitor()");
    }

    Monitor(int bright, int contrast) {
      // 다른 생성자를 호출할 수 있다
      // 단, 첫 문장을 와야 한다
      this(bright, contrast, 2560, 1200);
      System.out.println("Monitor(int, int)");
    }

    Monitor(int bright, int contrast, int widthRes, int heightRes) {
      this.bright = bright;
      this.contrast = contrast;
      this.widthRes = widRes;
      this.heightRes = heightRes;
    }
  }

}
