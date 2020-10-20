// Executors 태스크 프레임워크 - 스레드풀 종료 대기 : awaitTermination() 활용
package com.eomcs.concurrent.ex7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exam0520 {

  static class MyRunnable implements Runnable {
    int millisec;

    public MyRunnable(int millisec) {
      this.millisec = millisec;
    }

    @Override
    public void run() {
      try {
        System.out.printf("[%s] - 스레드 실행중...\n",
            Thread.currentThread().getName());

        Thread.sleep(millisec);

        System.out.printf("[%s] - 스레드 종료!\n",
            Thread.currentThread().getName());
      } catch (Exception e) {
        System.out.printf("[%s] 스레드 실행 중 오류 발생!\n", Thread.currentThread().getName());
      }
    }
  }


  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    executorService.execute(new MyRunnable(6000));
    executorService.execute(new MyRunnable(2000));
    executorService.execute(new MyRunnable(4000));
    executorService.execute(new MyRunnable(20000));

    executorService.shutdown();

    // 스레드풀의 모든 스레드가 종료될 때까지 기다린다.
    if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
      System.out.println("아직 종료 안된 작업이 있다.");
      System.out.println("남아 있는 작업의 강제 종료를 시도하겠다.");
      // => 만약 10초가 경과될 때까지 종료되지 않으면,
      //    수행 중인 작업을 강제 종료하라고 지시하고,
      //    대기 중인 작업은 취소한다
      executorService.shutdown();

      // 그리고 다시 작업이 종료될 때까지 기다린다.
      if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
        System.out.println("스레드풀의 강제 종료를 완료하지 못했다.");
      } else {
        System.out.println("모든 작업을 강제 종료했다.");
      }

    }

    System.out.println("main() 종료!");
  }

}
