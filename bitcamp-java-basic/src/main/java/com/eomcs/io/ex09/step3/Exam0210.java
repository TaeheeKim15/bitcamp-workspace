// 플러그인으로 전환한 BufferedInputStream 사용하기 - 읽기 시간 측정
package com.eomcs.io.ex09.step3;

import java.io.FileInputStream;

public class Exam0210 {

	public static void main(String[] args) throws Exception {

		BufferedInputStream in = new BufferedInputStream(new FileInputStream("temp/jls11.pdf"));

		int b;

		long startTime = System.currentTimeMillis(); // 밀리초

		int callCount = 0;
		while ((b = in.read()) != -1)
			callCount++;

		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
		System.out.println(callCount);

		in.close();
	}

}
