// stateless 방식에서 클라이언트를 구분하고 작업 결과를 유지하는 방법
package com.eomcs.net.ex04.stateless2;

import java.util.HashMap;
import java.util.Map;

public class CalcServer {

	// 각 클라이언트의 작업 결과를 보관할 맵 객체
	// => Map<clientID, result>
	static Map<Long, Integer> resultMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		System.out.println("서버 실행 중...");

		ServerSocket ss = new ServerSocket(8888);

		while
	}

}
