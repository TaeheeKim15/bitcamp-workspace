package com.eomcs.basic.ex03;


//# 정수 리터럴 - 메모리 크기에 따른 표기법
//- 정수를 저장할 메모리의 크기를 지정할 수 있다.
//- 메모리의 크기에 따라 표현할 수 있는 정수의 크기가 다르다
//
public class Exam0230 {
  public static void main(String[] args) {
    //## 4바이트 정수
    //접미사를 붙이지 않고 그냥 숫자를 표현하면 4바이트 크기의 메모리에 저장되는 정수 표현
    System.out.println(2147483647); // 4바이트 양의 정수 최대값
    System.out.println(-2147483648); // 4바이트 음의 정수 최솟값
    
    //4바이트 메모리 크기를 초과하면 컴파일 오류가 발생한다.
    //System.out.println
  }
}
