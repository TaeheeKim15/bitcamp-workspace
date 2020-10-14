package com.eomcs.pms;

import java.net.ServerSocket;

// stateful 통신
// => 클라이언트가 연결되면 클라이언트가 보낸 메시지를 그대로 리턴해 준다
public class ServerApp {
  public static void main(String[] args) throws Exception {
    try ( ServerSocket ss = new ServerSocket(8888)) {
      System.out.println("서버 실행중");

      new Thread(new ClientHandler(ss.accept())).start();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

