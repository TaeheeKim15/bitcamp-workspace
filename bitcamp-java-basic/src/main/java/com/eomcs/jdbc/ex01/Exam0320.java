// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : insert
package com.eomcs.jdbc.ex01;

import java.sql.DriverManager;

public class Exam0320 {

  public static void main(String[] args) throws Exception {

    try (java.sql.Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();


        java.sql.ResultSet rs = stmt.executeQuery(
            "select * from x_board order by board_id desc");

        ) {

      boolean isReceived = rs.next();

      if (isReceived) {
        System.out.printf("%s, %s, %s, %s, %s\n",
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5)
            );

      } else {
        System.out.println("서버에서 한 개의 레코드를 가져오지 못했다!");
      }

    }
  }
}





