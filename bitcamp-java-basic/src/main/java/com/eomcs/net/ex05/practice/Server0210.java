package com.eomcs.net.ex05.practice;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Server0210 {
	public static void main(String[] args) throws Exception {
		Scanner keyScan = new Scanner(System.in);

		System.out.println("서버 실행 중,,,");

		DatagramSocket socket = new DatagramSocket(8888);

		byte[] buf = new byte[8196];

		DatagramPacket emptyPacket = new DatagramPacket(buf, buf.length);

		System.out.println("데이터를 받기 전에 잠깐 멈추자!");
		keyScan.nextLine();

		socket.receive(emptyPacket);
		System.out.println("데이터 받았다 이눔아");

		socket.close();
		keyScan.close();

		String message = new String(emptyPacket.getData(),
				0,
				emptyPacket.getLength(), 
				"UTF-8"
				);
		System.out.println(message);

	}

}
