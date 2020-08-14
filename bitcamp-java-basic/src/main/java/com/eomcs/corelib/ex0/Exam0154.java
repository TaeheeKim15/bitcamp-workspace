// hash code 응용3 = Wrapper 클래스를 key 객체로 사용하기
package com.eomcs.corelib.ex0;

import java.util.HashMap;

public class Exam0154 {
  public static void main(String[] args) {
    // hash 코드는 Map에서 값을 저장하기 위해 key Student
    HashMap<Integer,Student> map = new HashMap<>();
    //Integer 이런 클래스를 wrapper 클래스라고 한다

    // Map은 값을 저장할 때 key를 이용한다.
    // => key:
    //    값을 저장할 위치를 계산할 때 사용한다.
    //    key 객체의 hashCode()를 호출하여 그 리턴 값을 사용하여 위치를 계산한다.
    //    따라서 key 객체의 해시코드가 다르면 위치도 다르다.
    // => map.put(key, value);
    //


    // key로 사용할 객체를 준비한다
    Integer k1 = new Integer(101);
    Integer k2 = new Integer(102);
    Integer k3 = new Integer(103);

    System.out.println(k1 == k2);
    System.out.println(k2 == k3);
    System.out.println(k3 == k1);

    // 위에서 준비한 key 객체를 가지고 Student 객체를 보관한다
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    //map.put(k3, new Student("김구", 17, true)); // 컴파일 오류
    // HashMap 객체를 만들 때 key 타입으로 Integer를 사용하기로 선언했기 때문에
    // 다른 타입을 키로 사용할 수 없다

    String str = new String("ohora");


    // put(Object key, Object value)
    // => put() 메서드는 key로 넘겨받은 객체에 대해 hashCode()를 호출하여
    //    정수 값을 얻는다.
    // => 그렇게 리턴 받은 정수 값(해시 코드)를 사용하여 Student 객체를 저장할 위치를 계산한다.
    // => 그런 후 그 위치에 해당하는 배열(배열로 관리한다면)에 저장한다.
    //


    // 다음과 같이 int를 key로 사용할 수 있다.
    // => key 값으로 int를 넘겨준다면,
    //    컴파일러가 컴파일할 때
    // 내부적으로 auto-boxing(자동으로 객체를 받는다)을 수행하여 Integer 객체를 만든다.
    //    그리고 그 객체를 넘겨주는 것이다.

    map.put(104/* new Integer(104) */ , new Student("안중근", 22, true));
    map.put(105/* new Integer(105) */ , new Student("윤봉길", 22, false));

    // 값을 저장할 때 사용한 key로 다시 값을 꺼내보자
    System.out.println(map.get(k2));

    // k2와 같은 정수 값을 가지는 key를 새로 생성한다
    Integer k6 = new Integer(102);

    // 다음과 같이 k6와 k2는 분명히 다른 객체이다
    System.out.println(map.get(k6));

    // 그러나 k2와 k6는 같은 해시코드를 갖는다.
    System.out.println(k2.hashCode()); // hash code는 같다
    System.out.println(k6.hashCode());

    // 또한 equals()의 리턴 값도 true 이다
    System.out.println(k2.equals(k6)); // equals()의 비교 결과도 같다





  }
}























