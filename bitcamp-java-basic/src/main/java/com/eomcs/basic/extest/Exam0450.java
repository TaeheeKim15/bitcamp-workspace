package com.eomcs.basic.extest;

// 비트 이동 연산자 : 응용 2
//
public class Exam0450 {
  public static void main(String[] args) {
    
    // 전 (32 바이트 사용)
    boolean c, cpp, java, js, python, php, html, css;
    c = true;
    cpp = false;
    java = true;
    js = false;
    python = true;
    php = false;
    html = true;
    css = false;
    
    // 배열 이용 (8 바이트 사용)
    boolean[] lang = new boolean[8];
    lang[0] = true;
    lang[1] = false;
    lang[2] = true;
    lang[3] = false;
    lang[4] = true;
    lang[5] = false;
    lang[6] = true;
    lang[7] = false;
    
    // 비트 연산자 사용 후 (4 바이트 사용)
    int lang2 = 0;
    
    
  }
}
