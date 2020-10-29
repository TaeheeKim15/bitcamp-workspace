// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : select, getXxx()
package com.eomcs.jdbc.ex01;

import java.sql.DriverManager;

public class Exam0330 {

  public static void main(String[] args) throws Exception {

    try (java.sql.Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc");

        ) {

      boolean isReceived = rs.next();

      if (isReceived) {
        System.out.printf("%d, %s, %s, %s, %d\n",
            rs.getInt("board_id"),
            rs.getString("title"),
            rs.getString("contents"),
            rs.getDate("created_date"),
            rs.getInt("view_count")
            );

      } else {
        System.out.println("서버에서 한 개의 레코드를 가져오지 못했다!");
      }

    }
  }
}





