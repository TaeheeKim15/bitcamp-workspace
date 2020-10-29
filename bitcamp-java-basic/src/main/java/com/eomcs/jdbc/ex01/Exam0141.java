package com.eomcs.jdbc.ex01;

import java.sql.DriverManager;

public class Exam0141 {
  public static void main(String[] args) {

    //  현재 jdbc.driver에 등록된 클래스 이름이 없다.
    System.out.printf("jdbc.drivers=%s\n", System.getProperty("jdbc.driver"));

    try {

      java.sql.Driver driver2 = DriverManager.getDriver("jdbc:mariadb://");
      System.out.println(driver2);

      java.sql.Driver driver3 = DriverManager.getDriver("jdbc:oracle:thin://");
      System.out.println(driver3);

      java.sql.Driver driver4 = DriverManager.getDriver("jdbc:sqlserver://");
      System.out.println(driver4);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
