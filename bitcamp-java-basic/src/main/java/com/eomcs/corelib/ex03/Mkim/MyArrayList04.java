package com.eomcs.corelib.ex03.Mkim;

// 4) 인스턴스를 특정 위치에 삽입하는 add(int, Object) 메서드를 정의한다

public class MyArrayList04 {

  static Object[] elementData = new Object[5];
  static int size;

  static public boolean add(Object e) {
    elementData[size++] = e;
    return true;
  }

  static public void add(int index, Object element) {
    for (int i = size; i > index; i--) {
      elementData[i] = elementData[i - 1];
    }
    elementData[index] = element;
    size++;

  }

  static public Object get(int index) {
    return elementData[index];
  }

}
