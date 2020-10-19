package com.eomcs.concurrent.ex7;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam0420 {

  static class MyRunnable implements Runnable {
    int millisec;

    public MyRunnable(int millisec) {
      this.millisec = millisec;
    }

    @Override
    public void run() {
      try {
        System.out.printf("%s 스레드 실행 중...\n",
            Thread.currentThread().getName());

        Thread.sleep(millisec);

        System.out.printf("%s 스레드 종료!\n",
            Thread.currentThread().getName());
      } catch (Exception e) {
        System.out.printf("%s 스레드 실행 중 오류 발생!\n", Thread.currentThread().getName());
      }
    }
  }

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    executorService.execute(new MyRunnable(6000));
    executorService.execute(new MyRunnable(2000));
    executorService.execute(new MyRunnable(4000));
    executorService.execute(new MyRunnable(5000));
    executorService.execute(new MyRunnable(6000));
    executorService.execute(new MyRunnable(7000));


    List<Runnable> tasks = executorService.shutdownNow();
    for (Runnable task : tasks) {
      System.out.println(((MyRunnable) task).millisec);
    }
    // 물론 새 작업 요청도 거절한다.
    // => 예외 발생!
    executorService.execute(new MyRunnable(4000));

    System.out.println("main() 종료!");
  }
}
