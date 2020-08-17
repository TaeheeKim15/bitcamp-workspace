package com.eomcs.corelib.ex03.Mkim;

// 테스트2 - MyArrayListTest2
// 10) remove()를 수행한 다음에 맨 끝에 남아 있는 주소를 null로 설정하여
//     인스턴스의 레퍼런스 카운트를 한개 줄인다.

public class MyArrayList10 {

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
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
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
    elementData[size] = null;
    // 쓰지 않는 인스턴스의 주소를 제거하여
    // 가비지가 될 수 있게 한다.

    return old;
  }

}











