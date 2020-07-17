package com.eomcs.basic.ex03;

//# 정수 리터럴 - 메모리 크기에 따른 표기법
//

public class Exam0240 {
    int a = 0xaaaaaaaa;
    int b = - 0xaaaaaaaa;
    public static void main(String[] args) {
        System.out.println(5 - 3);
        System.out.println(5 + (-3));

        // 0000 0011 <= +3 2진수:
        // 1111 1100 <= -3 2진수:
        // 1000 0011 <= -3 Sign-Magnitude
        // 0111 1100 <= -3 Excess-K = -3 + 127 = 124
        // K = 2**(비트수 - 1) - 1
        //   = 2**(8 - 1) - 1
        //   = 2**7 - 1
        //   = 128 - 1
        //   = 127   

        // 10101010 10101010 10101010 10101010 <= +aaaaaaaa 2진수:
        // 01010101 01010101 01010101 01010110<= -aaaaaaaa 2진수:
        // 55 55 55 56 < = 16진수
        // 0000 0100 <= -123 Excess-K = -123 + 127 = 4

    }
}