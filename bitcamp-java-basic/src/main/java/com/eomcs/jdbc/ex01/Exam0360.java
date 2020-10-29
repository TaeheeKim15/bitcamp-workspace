// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : insert
package com.eomcs.jdbc.ex01;

import java.sql.DriverManager;

public class Exam0360 {

  public static void main(String[] args) throws Exception {

    try (java.sql.Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");

        java.sql.Statement stmt = con.createStatement();) {

      //System.out.println(stmt.getClass().getName());

      int count = stmt.executeUpdate(
          "delete from x_board where board_id = 1");
      System.out.printf("%d 개 삭제 성공!", count);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}





