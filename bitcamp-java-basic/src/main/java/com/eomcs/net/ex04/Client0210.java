// 통신 방식 -  Stateless
package com.eomcs.net.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client0210 {
	public static void main(String[] args) {
		Scanner keyScan = new Scanner(System.in);

		while (true) {
			System.out.print("이름? ");
			String name = keyScan.nextLine();

			if(name.equalsIgnoreCase("quit")) {
				break;
			}

			// 요청할 때마다 서버와 연결한다
			try (Socket socket = new Socket("localhost", 8888); 
					PrintWriter out = new PrintWriter(socket.getOutputStream());
					BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

				System.out.println("서버와 연결되었삼!");

				// 한 번 요청한다					
				out.println(name);
				out.flush();

				// 응답받으면 서버와 연결을 끊는다
				String str = in.readLine();
				System.out.println(str);

				System.out.println("서버와 끊었삼!");

			} catch (Exception e) {
				e.printStackTrace();
			}


		}


		keyScan.close();
	}
}

// stateful 방식
// => 서버와 연결한 후, 클라이언트에서 연결을 끊을 때까지 
// 계속해서 연결을 유지하며 클라이언트 요청을 처리한다
// 단점
// - 한 번 연결하면 클라이언트가 연결을 끊을 때까지 계속 유지한다
// - 클라이언트가 작업을 요청하지 않더라도 계속
// 서버에 연결정보를 계속 유지하기 때문에
// 서버 메모리를 많이 차지하고
// 동시에 많은 클라이언트의 요청을













