// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : select, getXxx()
package com.eomcs.jdbc.ex02;

import java.sql.DriverManager;

public class Exam0120 {

  public static void main(String[] args) throws Exception {

    try (java.sql.Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();
        java.sql.ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc");) {

      System.out.println("번호, 제목, 등록일, 조회수");

      while(rs.next()) {
        System.out.printf("%d, %s, %s, %d\n",
            rs.getInt("board_id"),
            rs.getString("title"),
            rs.getDate("created_date"),
            rs.getInt("view_count")
            );

      }

    }
  }
}





