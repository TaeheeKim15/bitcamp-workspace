package com.eomcs.corelib.ex0;

import java.util.HashMap;

public class Exam0155 {
  public static void main(String[] args) {
    HashMap<String, Student> map = new HashMap<>();


    String k1 = new String("ok");
    String k2 = new String("no");
    String k3 = new String("haha");
    String k4 = new String("ohora");
    String k5 = new String("hul");

    // String 을 key로 사용해보자
    map.put(k1,  new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    map.put(k4,  new Student("안중근", 24, false));
    map.put(k5, new Student("윤봉길", 22, false));

  }
}
