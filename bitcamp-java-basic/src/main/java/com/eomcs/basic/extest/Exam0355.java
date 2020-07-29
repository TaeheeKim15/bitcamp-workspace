package com.eomcs.basic.extest;

//# 비트 연산자 & 활용: 픽셀에서 파란색의 값을 강화시키고 싶다
//
public class Exam0355 {
  public static void main(String[] args) {
    int pixel = 0x003f4478; // 각 바이트의 값이 '00RRGGBB'이라 가정한다
    System.out.println(pixel | 0x00000057);
    
  }

}
