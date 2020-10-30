package com.eomcs.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam0220
{
  public static void main(String[] args) throws Exception {
    String no = null;
    String title = null;
    String contents = null;

    try (Scanner keyScan = new Scanner(System.in)) {

      System.out.print("번호? ");
      no = keyScan.nextLine();

      System.out.print("제목? ");
      title = keyScan.nextLine();

      System.out.print("내용? ");
      contents = keyScan.nextLine();

      System.out.print("입력하시겠습니까?(Y/n) ");
      String input = keyScan.nextLine();

      if (!input.equalsIgnoreCase("y") && input.length() != 0) {
        System.out.println("등록을 취소 하였습니다.");
        return;
      }
    }

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");

        PreparedStatement stmt = con.prepareStatement(
            "update x_board set title = ?, contents = ? where board_id = ?")) {

      // 순서대로 상관없지만, 코드에 개성살리지 말자
      stmt.setString(3, no);
      stmt.setString(1, title); // int 컬럼의 값을 setString()으로 설정할 수 있다.
      stmt.setString(2, contents);
      // SQL 문장을 준비할 때, 값이 들어갈 자리에 ?로 표시한다
      // ? 를 "in-parameter"라 부른다.
      //
      // SQL을 서버에 전달하기 전에 in-parameter 값에 넣는다.

      int count = stmt.executeUpdate();

      if (count == 0) {
        System.out.println("해당 번호의 게시글이 존재하지 않습니다.");
      } else {
        System.out.println("변경하겠습니다.");
      }
    }
  }

}























