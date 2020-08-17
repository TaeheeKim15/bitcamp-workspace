package com.eomcs.corelib.ex03.Mkim;

// 6) 특정 위치의 항목을 제거하는 remove(int) 메서드를 정의한다

public class MyArrayList06 {

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

  static public Object remove(int index) {
    Object old = elementData[index];

    for (int i = index; i < size - 1; i++) {
      elementData[i] = elementData[i + 1];
    }

    size--;

    return old;
  }

}











