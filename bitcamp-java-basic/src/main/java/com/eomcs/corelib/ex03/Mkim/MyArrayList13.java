package com.eomcs.corelib.ex03.Mkim;

// 테스트3 - MyArrayListTest3
// 13) 캡슐화 적용하여 공개할 멤버와 공개하지 말아야 할 멤버를 구분한다

public class MyArrayList13 {

  private Object[] elementData = new Object[5];
  private int size;

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

    public int size() {
      return this.size;

      // 이거 왜 메소드로 선언해 준거여?
      // - size의 값을 밖에서는 못 바꾸게 private 선언해주고
      //   기능은 쓸 수 있게 메소드를 만들어 준다
      //   메소드는 기능은 쓸 수 있지만 size라는 변수는 바꿀 수 없으니까!
    }

}











