package com.eomcs.basic.ex04;

//#배열 - 배열 레퍼런스와 배열 인스턴스
//

public class Exam0530 {
  public static void main(String[] args) {
    
    int[] arr1 = new int[5];
    
    // 배열 선언문 분석:
    // arr1
    // - 배열 메모리의 주소를 담는 변수이다.
    // - 이렇게 메모리의 주소를 보관하는 변수를 '레퍼런스'라고 부른다.
    //
    // new int[5]
    //  - new 명령은 사용할 메모리를 확보하는 명령
    //  - 즉 연속된 5개의 int 타입 메모리를 준비해라
    //  - 사용할 메모리를 확보한 후 그 메모리를 찾아 주소 리턴
    //  - 이렇게 값을 저장하기 위해 확보된 메모리를 "인스턴스"라고 부른다.
    // 
    // new 명령은 메모리를 확보하는 명령이다.
    // - 리턴 값은 확보된 메모리의 시작 주소이다.
    
    //
    arr1 = new int[5];
    
    arr1[0] = 100; // arr1에 저장된 주소로 찾아가서 0번째 값 넣어라
    arr1[1] = 200; // arr1에 저장된 주소로 찾아가서 1번째 값 넣어라
    
    System.out.println(arr1[0]);
    System.out.println(arr1[1]);
  }
}
