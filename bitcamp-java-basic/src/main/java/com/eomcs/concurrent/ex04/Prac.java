// 스레드의 생명 주기 - running 상태: CPU 쟁탈전(racing)
package com.eomcs.concurrent.ex04;

public class Prac {
	public static void main(String[] args) throws Exception {
		class MyThread extends Thread {

			public MyThread(String name) {
				super(name);
			}

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.printf("%s %d\n", this.getName(), i);
				}
			}

			MyThread t1 = new MyThread("김태희 ===> ");
			MyThread t2 = new MyThread("하하하 ~~> ");
			MyThread t3 = new MyThread("아침 공부는 재밌어! ");

			// 스레드를 시작시키는 순간 running  상태로 접어든다
			// running 상태는 실행하고 있는 상태 뿐 아니라
			// CPU를 받을 수 있는 상태기도 하다
			// => CPU는 OS의 관리 정책에 따라 스레드나 프로세스에 배분된다
			// 			물론 OS가 CPU를 배분한 후 임의시간 후에
			// 			다시 회수하여 


		}
	}

}
