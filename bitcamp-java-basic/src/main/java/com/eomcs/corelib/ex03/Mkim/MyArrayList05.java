package com.eomcs.corelib.ex03.Mkim;

// 5) 특정 위치의 항목을 다른 인스턴스로 교체하는 set(int, Object) 메서드를 정의한다

public class MyArrayList05 {

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

  static public Object set(int index, Object element) {
    Object preElement = elementData[index];
    elementData[index] = element;
    return preElement;
  }

}
