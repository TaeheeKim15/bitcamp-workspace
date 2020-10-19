package com.eomcs.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam0110 {
  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newFixedThreadPool(3);
    class X implements Runnable {
      @Override
      public void run() {
        System.out.printf("%s 스레드 실행!", Thread.currentThread().getName());
      }
    }
    threadPool.execute(new X());

    System.out.println("main() 종료");
  }
}
