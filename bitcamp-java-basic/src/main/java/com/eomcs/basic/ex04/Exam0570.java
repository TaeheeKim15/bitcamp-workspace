package com.eomcs.basic.ex04;

//# 배열 - 배열 메모리 초기화
public class Exam0570 {
  public static void main(String[] args) {
    // 배열 선언
    int[] arr1 = new int[5]; 
    
    // 배열 메모리를 특정 값으로 초기화
    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;
    
    // 1) 배열 선언 + 초기화 명령
    int arr2[] = new int[] {100, 90, 80, 70, 60};
    
    //2) 배열 선언 + 초기화 명령2
    int arr3[] = {0, 0, 0, 0, 0}; 
    
    // 그러나 배열 변수를 선언한 후 따로 초기화시킬 때는
    // 다음과 같이 new 명령을 생략할 수 있다.
    int[] arr4;
    //arr4 = { 100, 90, 80, 70, 60}
    
    // 배열 초기화 명령을 따로 실행할 때는 new int[]를 생략 불가능
    int[] arr5;
    arr5 = new int[] {0, 0, 0, 0, 0};
    
  }
}
