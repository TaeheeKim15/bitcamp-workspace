// BufferedInputStream과 BufferedOutputStream을 사용하여 파일 복사 및 시간 측정
package com.eomcs.io.ex09.step3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Exam0220 {

	public static void main(String[] args) throws Exception {
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream("temp/jls11.pdf"));

		BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream("temp/jls11_5.pdf"));

		int b;

		long startTime = System.currentTimeMillis();

		while ((b = in.read()) != -1)
			out.write(b);

		long endTime = System.currentTimeMillis();

		in.close();
		out.close();

	}

}
