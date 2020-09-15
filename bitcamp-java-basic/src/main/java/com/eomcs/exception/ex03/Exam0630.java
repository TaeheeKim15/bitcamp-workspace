// 예외 처리 후 마무리 작업 -  try-with-resources
package com.eomcs.exception.ex03;

import java.util.Scanner;

public class Exam0630 {

	static void m() throws Exception {
		// 자원해제시키는 코드를 매번 작성하기가 귀찮다!
		// => try-with-resources 라는 문법을 사용하면
		// 굳이 finally 블록에서 close()를 직접 호출할 필요가 없다.
		// 자동으로 처리한다.
		// => 단 java.lang.AutoCloseable 구현체에 대해서만 가능하다!
		// => 문법
		// try (java.lang.AutoCloseable 구현체) {...}

		try (Scanner keyScan = new Scanner(System.in);

				// FileReader 클래스도 java.lang.AutoCloseable 구현체이다.
				FileReader in = new FileReader("Hello.java")
	}


	public static void main(String[] args) {
		m();
	}

}
