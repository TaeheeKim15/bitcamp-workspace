package com.eomcs.jdbc.ex01;

import java.sql.DriverManager;

public class Exam0210 {
  public static void main(String[] args) {

    java.sql.Connection con = null;


    try {

      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", // jdbcURL
          "study" , // username
          "1111" // password
          );

      System.out.println("DBMS와 연결됨");

      System.out.println(con.getClass().getName());

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        con.close();
      } catch (Exception e) {
      }
      System.out.println("DBMS와 연결 해제됨!");
    }
  }


}
