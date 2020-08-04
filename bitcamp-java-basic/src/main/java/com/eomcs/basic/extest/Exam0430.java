package com.eomcs.basic.extest;

//# 비트 이동 연산자 : >>, >>>, <<
//
public class Exam0430 {
  public static void main(String[] args) {
    
    int i = 105;
    
    System.out.println(i);
    
    System.out.println(i >>> 1);
    
    System.out.println(i >>> 2);
    
    System.out.println(i >>> 3);
    
    System.out.println(i >>> 4);
  }
} 

// >>> 비트 이동 연산자 사용법
// - 오른쪽으로 비트를 이동시킨다.
// - 왼쪽 빈자리를 음수 양수 상관없이 무조건 0으로 채운다.
// - 오른쪽 경계를 넘어간 비트는 자른다.

// [00000000000000000000000001101001]           => 105

// [ 0000000000000000000000000110100]1
// [00000000000000000000000000110100]1          => 52

// [  000000000000000000000000011010]01
// [00000000000000000000000000011010]01         => 26

// [   00000000000000000000000001101]001
// [00000000000000000000000000001101]001        => 13

// [    0000000000000000000000000110]1001
// [00000000000000000000000000000110]1001       => 6