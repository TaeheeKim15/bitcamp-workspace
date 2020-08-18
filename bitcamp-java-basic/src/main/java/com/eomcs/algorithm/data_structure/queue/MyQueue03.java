package com.eomcs.algorithm.data_structure.queue;

import com.eomcs.algorithm.data_structure.linkedlist.MyLinkedList;

// 1) Queue를 구현하기 위해 기존에 작성한 MyLinkedList를 상속받는다
// 2) Queue의 값을 추가하는 offer(Object)를 정의한다
// 3) Queue에서 값을 꺼내는 poll()을 정의한다
public class MyQueue03 extends MyLinkedList {

  public boolean offer(Object e) {
    return add(e);
    // return this.add(e);
    // 인스턴스 메소드를 줄 때는 반드시 앞에 인스턴스 주소를 주어야 한다
    // 다만 상속받을 때 생략할 수 있다.
  }

  public Object poll() {
    if (size() == 0) {
      return null;
    }
    return remove(0);
  }
}
