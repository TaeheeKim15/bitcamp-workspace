// String - String.equals() 처럼 동작하게 만들기
package com.eomcs.corelib.ex012;

public class Exam0123 {

  static class Member {
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;

    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + age;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Member other = (Member) obj;
      if (age != other.age)
        return false;
      if (name == null) {
        if (other.name != null)
          return false;
      } else if (!name.equals(other.name))
        return false;
      return true;
    }

    // String의 equals()처럼 내용이 같은지를 비교하도록 만들고 싶다면,
    // Object에서 상속 받은 메서드를 오버라이딩 하라.

  }
   public static void main(String[] args) {

     Member m1 = new Member("홍길동", 20);
     Member m2 = new Member("홍길동", 20);

     // 인스턴스는 다르지만,
     System.out.println(m1 == m2); // false

     // 인스턴스의 내용물이 같기 때문에 결과는?
     System.out.println(m1.equals(m2));


  }


}



























