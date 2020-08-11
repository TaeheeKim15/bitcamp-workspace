package com.eomcs.oop.apractice.ex03;

public class Exam0150 {

  static class Student {

    // 클래스 필드 = 스태틱 필드
    // - 모든 인스턴스가 공유하는 값을 저장할 때는 클래스 변수를 사용한다
    static int count;

    //인스턴스 필드
    // - 인스턴스마다 개별적으로 관리해야 할 값을 인스턴스 변수에 저장한다.
    String name;
    int age;

  }

  public static void main(String[] args) {

    //클래스 필드는 인스턴스를 생성할 필요 없이 클래스 이름으로 바로 사용한다
    Student.count = 0;

    // 인스턴스 필드는 new 명령을 수행해야지만 생성된다.
    Student s1 = new Student();
    s1.name = "홍길동"; // 인스턴스 필드는 인스턴스 주소(s1)가 있어야만 접근할 수 있다.
    s1.age = 10;

    //  클래스 이름으로는 인스턴스 필드에 접근할 수 없다.
    // A.name = "홍길동";

    Student.count++;

    Student s2 = new Student();
    s2.name = "임꺽정";
    s2.age = 20;

    Student.count++; // 이처럼 클래스  필드는 클래스 이름을 사용하라

    System.out.println();

  }
}
