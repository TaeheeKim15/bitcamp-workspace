// 아규먼트에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0313 {

	static interface Player {
		void play();
	}

	static void testPlayer(Player player) {
		player.play();
	}

	public static void main(String[] args) {
		// 아규먼트 부분에 바로 익명 클래스를 정의하는 코드를 두면
		// 코드를 해석하기가 편하다
		testPlayer(() -> System.out.println("실행~~~"));
	}
}
