package com.eomcs.corelib.ex03.Mkim;

// 테스트3 - MyArrayListTest3
// 12) 여러 개의 목록을 동시에 관리할 수 있도록
//     MyArrayList에 선언된 레퍼런스 배열을 스태틱 대신 인스턴스로 사용해야 한다
//     - 개별적으로 관리해야 할 데이터는 인스턴스 변수를 사용해야 한다.

public class MyArrayList12 {

  Object[] elementData = new Object[5];
  int size;

  public boolean add(Object e) {
    if (size == elementData.length) {
      grow();
    }
    elementData[size++] = e;
    return true;
  }

  private void grow() {
    System.out.println("오호라! 배열을 늘리자");
    Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
    for (int i = 0; i < elementData.length; i++) {
      newArray[i] = elementData[i];
    }
    elementData = newArray;
  }

  public void add(int index, Object element) {
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

  public Object get(int index) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    return elementData[index];
  }

  public Object set(int index, Object element) {
    if (index < 0 || index >= size) {
      throw new ArrayIndexOutOfBoundsException("인덱스가 유효하지 않습니다.");
    }
    Object preElement = elementData[index];
    elementData[index] = element;
    return preElement;
  }

    public Object remove(int index) {
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











