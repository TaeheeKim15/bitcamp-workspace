package com.eomcs.basic.ex03;

//# 정수 리터럴 - 자릿수 표기
//- 정수를 읽기 쉽도록 밑줄(underscore; _)을 숫자 사이에 삽입할 수 있다.
//
public class Exam0220 {
    public static void main(String[] args) {

        //## 10진수에 _ 문자를 삽입하기
        System.out.println(1283406);
        System.out.println(1278_3406);
        System.out.println(12_783_406);

        //숫자 맨 앞 또는 맨 뒤에 삽입할 수 없다.
        //System.out.println(_12783406);
        //System.out.println(12783406_);

        //숫자 맨 앞 또는 맨 뒤에 삽입할 수 없다.
        //System.out.println(_077);
        //System.out.println(077_);

        //## 16진수에 _ 문자를 삽입하기
        System.out.println(0xffaa);
        System.out.println(0xff_aa);

        //숫자 맨 앞 또는 맨 뒤에 삽입할 수 없다.
        //System.out.println(0x_ffaa);
        //System.out.println(0xffaa_);
    }
}