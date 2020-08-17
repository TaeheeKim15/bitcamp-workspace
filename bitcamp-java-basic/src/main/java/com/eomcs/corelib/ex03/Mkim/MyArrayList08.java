package com.eomcs.corelib.ex03.Mkim;

// 테스트2 - MyArrayListTest2
// 8) add(int, Object)로 임의의 위치에 삽입할 때
//    - 배열의 크기가 작으면 늘린다
//    - 인덱스가 유효하지 않으면 예외를 발생시킨다

public class MyArrayList08 {

  static Object[] elementData = new Object[5];
  static int size;

  static public boolean add(Object e) {
    if (size == elementData.length) {
      grow();
    }
    elementData[size++] = e;
    return true;
  }

  static private void grow() {
    System.out.println("오호라! 배열을 늘리자");
    Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
    for (int i = 0; i < elementData.length; i++) {
      newArray[i] = elementData[i];

    }
    elementData = newArray;
  }

  static public void add(int index, Object element) {
    if (size == elementData.length) {
       grow();

    }
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }

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











