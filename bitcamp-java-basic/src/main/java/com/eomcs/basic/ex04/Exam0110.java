// 변수 선언
// - 데이터를 저장할 메모리를 확보하는 명령
//
package com.eomcs.basic.ex04;

public class Exam0110 {
  public static void main(String[] args) {
    int i;
    int i2;
    int i3;
    
    int x, y, z;
    
    i = 100;
    x = i;
    y = i * x;
    
    byte b1 = 10; // [00001010]
    byte b2 = 12; // [00001100]
    b1 = b2; // b1 => [00001100]
    
    i = b1; //[000000000000...00001100]
    
    // b2 = i; -> 큰 값을 작은 값에 넣으려고 하면 compile error가 뜬다.
    
    b2 = (byte)i;
    
    int a = 100;
    int b = 200;
    
    int aa, bb = 100, cc = 200, dd;
    
    byte xx = 10; // 0000 1010
    xx = 12; // 0000 1100
    xx = 78; // 01001110
  }
}

/*
 * int <- 메모리 종류(Data Type)
 * i <- 확보한 메모리 이름(변수, variable)
 *{ 정수 : int(4), long(8), byte(1), short(2)
 * 부동소수점: float(4), double(8)
 * 문자: char(2)
 * 논리: boolean(4바이트 <- 일반 || 1바이트 <- 배열)} ⊂ primitive data type(자바 기본 데이터 타입)
 * 변수명 = 값;
 * i =(<- assignment operator, 할당/배정 연산자 <> equal 연산자, ==) 100;
 * 연산자를 기준으로 왼쪽을 L-Value, 오른쪽을 R-Value 라고 한다.
 * L-Value에는 메모리 즉, 변수만 올 수 있다(값 X)
 * R-Value에는 값, 메모리, 표현식(experssion) 올  수 있음
 * 표현식 : 결과를 생성하는 리턴 문장
 * 표현식 ⊂ 문장 ( 변수선언, 메서드 선언, 조건문 등등)
 * 문장(statement)
 * int x;
 * x = 100;
 * int y;
 * y= 200;
 */
// >, <, >=, <=, ==
// && || ^
// 
//
