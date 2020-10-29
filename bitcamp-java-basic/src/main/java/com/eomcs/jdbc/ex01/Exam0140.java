package com.eomcs.jdbc.ex01;

import java.sql.DriverManager;

public class Exam0140 {
  public static void main(String[] args) {


    try {

      System.out.printf("java.home=%s\n", System.getProperty("java.home"));
      System.out.printf("user.home=%s\n", System.getProperty("user.home"));

      //java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb://");
      System.setProperty("jdbc.drivers", "org.mariadb.jdbc.Driver:com.eomcs.jdbc.ex01.MyDriver");
      System.out.printf("jdbc.drivers=%s\n", System.getProperty("jdbc.driver"));

      java.sql.Driver driver3 = DriverManager.getDriver("jdbc:oracle:thin://");
      System.out.println(driver3);

      java.sql.Driver driver4 = DriverManager.getDriver("jdbc:sqlserver://");
      System.out.println(driver4);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
