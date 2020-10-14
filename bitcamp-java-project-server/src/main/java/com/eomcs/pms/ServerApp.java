package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

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

  // 클라이언트 요청을 처리하는 일을 한다
  // 다른 클래스가 사용할 일이 없기 때문에 private 으로 선언한다
  // 바깥 클래스의 특정 인스턴스 멤버를 사용할
  private static class ClientHandler implements Runnable {
    Socket socket;

    public ClientHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {

      InetAddress address = this.socket.getInetAddress();
      System.out.printf("클라이언트(%s)가 연결되었습니다.\n",
          address.getHostAddress());

      try (Socket socket = this.socket; // try 블록을 떠날 때 close()가 자동 호출된다.
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        while (true) {
          String request = in.readLine();

          sendResponse(out, request);

          if (request.equalsIgnoreCase("quit"))
            break;
        }


      } catch (Exception e) {
        System.out.println("클라이언트와의 통신 오류!");
      }

      System.out.printf("클라이언트(%s)와의 연결을 끊었습니다.\n",
          address.getHostAddress());
    }

    private void sendResponse(PrintWriter out, String message) {
      out.println(message);
      out.println(); // 응답이 끝났음을 알리는 빈 줄을 보낸다.
      out.flush();
    }
  }
}

