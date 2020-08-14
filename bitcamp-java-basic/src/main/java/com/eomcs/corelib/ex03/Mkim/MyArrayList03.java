package com.eomcs.corelib.ex03.Mkim;


//3) 특정 인덱스의 인스턴스를 리턴하는 get(int) 메서드 정의한다

public class MyArrayList03 {

  static Object[] elementData = new Object[5];
  static int size;

  static public boolean add(Object e) {
    elementData[size++] = e;
    return true;
  }

  static public Object get(int index) {
    return elementData[index];
  }

}
