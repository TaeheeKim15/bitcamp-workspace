// hash code 응용 2 - MyKey의 hashCode()와 equals() 오버라이딩 하기
package com.eomcs.corelib.ex0;

import java.util.HashMap;
import com.eomcs.corelib.ex0.Exam0150.Student;

public class Exam0153 {
  
  static class MyKey2 {
    String contents;
    
    public MyKey2(String contents) {
      this.contents = contents;
    }
    
    public String toString() {
      return "MyKey2 [contents=" + contents + "]";
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((contents == null) ? 0 : contents.hashCode());
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
      MyKey2 other = (MyKey2) obj;
      if (contents == null) {
        if (other.contents != null)
          return false;
      } else if (!contents.equals(other.contents))
        return false;
      return true;
    }
  } public static void main(String[] args) {
    HashMap<MyKey2, Student> map = new HashMap<>();
    
    MyKey2 k1 = new MyKey2("ok");
    MyKey2 k2 = new MyKey2("no");
    MyKey2 k3 = new MyKey2("haha");
    MyKey2 k4 = new MyKey2("ohora");
    MyKey2 k5 = new MyKey2("hul");
    
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    map.put(k4, new Student("안중근", 24, true));
    map.put(k5, new Student("윤봉길", 22, false));
    
    // 실무에서는 따로 키를 만들지 않는다
    // 해시밉에서 사용하는 키는 해시코드랑 해시코드를 오버라이딩한다
    // 실무에서는 키를 String이나 integer를 써라
    
    System.out.println(map.get(k3));
    
    // 다른 key 객체를 사용하여 값을 꺼내보자
    MyKey2 k6 = new MyKey2("haha");
    
    System.out.println(map.get(k6));
    // k3 와 k6는
    // hashCode()의 리턴 값이 같다
    // equals() 비교 결과도 true 이기 때문에
    // HashMap 클래스에서는 서로 같은 key라고 간주한다.
    
    System.out.println(k3 == k6); // 인스턴스는 다르다
    System.out.printf("k6(%s), k6(%s)\n", k3, k6);
    System.out.println(k6.hashCode()); // hash code는 같다
    System.out.println(k6.hashCode()); // hash code는 같다
    System.out.println(k3.equals(k6));
    
  }
  
  

}































