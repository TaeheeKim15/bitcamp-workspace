package com.eomcs.corelib.ex03.Mkim;


//2) 인스턴스를 추가하는 add(Object) 메서드를 정의한다
public class MyArrayList02 {

  static Object[] elementData = new Object[5];
  static int size;

  static public boolean add(Object e) {
    elementData[size++] = e;
    return true;

  }

}
