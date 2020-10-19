package com.eomcs.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam0120 {

  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(3);

    threadPool.execute(() ->System.out.printf("%s 스레드 실행!", Thread.currentThread().getName()));

    System.out.println("main() 종료");
  }
}


// 인터페이스의 메서드가 하나라면
// 추상은 안된다.