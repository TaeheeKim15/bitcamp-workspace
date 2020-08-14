// StringBuffer - 문자열 비교 II
package com.eomcs.corelib.ex02;

public class Exam0125 {
  public static void main(String[] args) {

    StringBuffer b1 = new StringBuffer("Hello");
    StringBuffer b2 = new StringBuffer("Hello");


    // StringBuffer 에 들어 있는 문자열을 비교하려면?
    // - StringBuffer에서 String을 꺼내 비교하라!
    //
    // String s1 = b1.toString();
    // String s2 = b2.toString();
    // System.out.println(s1.equals(s2));
    //

    System.out.println(b1.toString().equals(b2.toString()));
    // b1.toString -> string으로 값나옴
    // b2.toString() -> string으로 값나옴
    // String 값들은 equals로 비교함

    // String은 equals를 오버라이딩했지만
    // StingBuffer은 equals를 오버라이딩하지 않았다
  }
}


