package com.eomcs.basic.ex04;

//# 부동소수점 변수 - 변수와 리터럴 크기
// 
public class Exam0425 {
  public static void main(String[] args) {
    
    float f1 = 99988.88f;
    float f2 = 11.11111f;
    
    // 각 변수의 값이 개별적으로 옳은 부동소수점이라도,
    System.out.println(f1);
    System.out.println(f2);
    
    // 주의!
    // 연산 결과가 해당 타입의 크기를 벗어난다면, 그 결과 값은 잘린다.
    float f3 = f1 + f2;
    System.out.println(f3);
    
    // 그래서 부동소수점을 다룰 때는 가능한 float 보다 두 배 더 정밀한
    // double을 사용하자
    // 즉, 부동소수점 뒤에 d나 D 표시를 생략할 수 있다.
    double d1 = 99988.88;
    double d2 = 11.11111;
    double d3 = d1 + d2;
    System.out.println(d3);
    
        
  }

}
