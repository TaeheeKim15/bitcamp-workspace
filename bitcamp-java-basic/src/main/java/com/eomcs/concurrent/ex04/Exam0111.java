// 스레드의 생명주기(lifecycle) - 죽은 스레드는 다시 살릴 수 없다
package com.eomcs.concurrent.ex04;

public class Exam0111 {
	public static void main(String[] args) {

		Thread t = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("===> " + i);
			}
		});
		t.start();

		System.out.println("main() 종료!");
	}

}
