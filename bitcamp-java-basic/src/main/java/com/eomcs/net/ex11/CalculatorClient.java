// 계산기 클라이언트 만들기 - 6단계: 사용자에게 프롬프트를 제시하고 계산식을 입력받기
package com.eomcs.net.ex11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
	public static void main(String[] args) {

		try (Scanner keyboardScanner = new Scanner(System.in);
				Socket socket = new Socket("localhost", 8888);
				PrintStream out = new PrintStream(socket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

			readResponse(in);

			while (true) {
				String input = keyboardScanner.nextLine();
				sendRequest(out, input); // 서버의 요청을 보내기
				readResponse(in); // 서버의 실행 결과를 출력

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void readResponse(BufferedReader in) throws Exception {
		while (true) {
			String input = in.readLine();
			if (input.length() == 0) {
				// 빈 줄을 읽었다면 읽기를 끝낸다.
				break;
			}
			System.out.println(input);
		}
	}

	static void sendRequest(PrintStream out, String message) {
		out.println(message);
		out.flush();
	}
}
야 임마 프롬프트 만들어라!!!!!!!

