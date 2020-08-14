package com.eomcs.corelib.ex03.trash;

// 객체(자동차) <= 인스턴스(버스)
// add가 boolean 어디서 나왓누

// 1) 인스턴스 배열을 담을 레퍼런스 배열을 준비한다
// 2) 인스턴스를 추가하는 add()메서드 추가

public class MyArrayList01 {

  static Object[] elementData = new Object[5];
  static int size;

  static public boolean add(Object e) {
    elementData[size++] = e;
    return true;
  }

}
