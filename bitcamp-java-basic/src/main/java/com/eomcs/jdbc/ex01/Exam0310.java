// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : insert
package com.eomcs.jdbc.ex01;

import java.sql.DriverManager;

public class Exam0310 {

  public static void main(String[] args) throws Exception {

    try (java.sql.Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");

        java.sql.Statement stmt = con.createStatement();) {

      System.out.println(stmt.getClass().getName());

      int count = stmt.executeUpdate(
          "insert into x_board(title, contents) values('제목10','내용')");
      System.out.printf("%d 개 입력 성공!", count);
    }
  }
}





