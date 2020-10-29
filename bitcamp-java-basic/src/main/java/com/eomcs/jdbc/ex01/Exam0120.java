package com.eomcs.jdbc.ex01;

import java.sql.DriverManager;

public class Exam0120 {
  public static void main(String[] args) {


    try {
      new org.mariadb.jdbc.Driver();
      new oracle.jdbc.driver.OracleDriver();
      new com.microsoft.sqlserver.jdbc.SQLServerDriver();



      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb://");
      System.out.println(driver);

      java.sql.Driver driver3 = DriverManager.getDriver("jdbc:oracle:thin://");
      System.out.println(driver3);

      java.sql.Driver driver4 = DriverManager.getDriver("jdbc:sqlserver://");
      System.out.println(driver4);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
