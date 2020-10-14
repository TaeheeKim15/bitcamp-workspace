package com.eomcs.pms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import com.eomcs.util.Prompt;

public class ClientApp {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("프로그램 사용법 :  ");
      System.out.println("    java -cp ... ClientApp 서버주소 포트번호");
      System.exit(0);
    }

    try (Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      while (true) {
        String input = Prompt.inputString("명령> ");
        out.println(input);
        out.flush();

        receiveResponse(in);

        if (input.equalsIgnoreCase("quit"))
          break;
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private static void receiveResponse(BufferedReader in) throws Exception {

    while (true){
      String response = in.readLine();
      if (response.length() == 0)
        break;
      System.out.println(response);
    }
  }
}
