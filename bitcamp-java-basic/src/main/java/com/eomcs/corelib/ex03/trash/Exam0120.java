// java.util.ArrayList와 비교
package com.eomcs.corelib.ex03.trash;

import java.util.ArrayList;

public class Exam0120 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("aaa"); // aaa,
    list.add("bbb"); // aaa, bbb,
    list.add("ccc"); // aaa, bbb, ccc,
    list.add("ddd"); // aaa, bbb, ccc, ddd,

    // aaa, bbb와 같은 주소 목록을 관리한다
    // 인스턴스 관리 X
    // 인스턴스 임의 변경도 안된다
    // 위치는 그대로 유지

    print(list);

    list.remove(2); // aaa, bbb, ddd,
    // (대충 2번방 주소가 날린다는 명령이라는 뜻)
    // 2번은 어디갔나요?
    // => garbage 되부럿쓰
    print(list);

    list.remove(0); // bbb, ddd,
    print(list);

    // 유효한 인덱스가 아니면 예외 발생시킨다!
    //    list.remove(4); // 실행 오류!
    //    print(list);
    //
        list.add(1, "xxx"); // bbb, xxx, ddd,
        list.add(1, "yyy"); // bbb, yyy, xxx, ddd
        list.add(0, "zzz"); // zzz, bbb, yyy, xxx, ddd
        print(list);

        // 삽입할 인덱스가 배열의 크기를 가리킬 경우, 맨 끝에 추가한다.
        list.add(5, "ttt"); // zzz, bbb, yyy, xxx, ddd, ttt
        print(list);
    //
        list.set(1, "aaa"); // zzz, aaa, yyy, xxx, ddd, ttt
        print(list);
        // set 은 값을 변경

        list.add("ccc"); // zzz, aaa, yyy, xxx, ddd, ttt, ccc
        print(list);

        list.add("eee"); // zzz, aaa, yyy, xxx, ddd, ttt, ccc, eee
        print(list);
  }

  static void print(ArrayList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ", ");
    }
    System.out.println();

    // 값을 꺼낸다기보다는 값을 조회한다는 개념에 가깝다
  }
}


