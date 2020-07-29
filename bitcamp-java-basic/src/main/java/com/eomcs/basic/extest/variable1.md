#### 변수 사용 
####### - 다른 도구(메서드; 함수라고도 부른다)에 값을 전달할 수 있다  

---

##### 예제 1 (변수 사용 1)

---


```
  public class Exam0310 {
  public static void main(String[] args) {
    
    int age = 20;
    
    System.out.println(age); 
  }
}
```
> ###### 1. println() 메서드(도구)
     - 콘솔(console)로 값을 출력할 때 사용하는 도구이다.
     -  즉 JVM의 표준 출력 장치로 값을 출력한다.
> ###### 2. 사용법
    - System.out.println(리터럴 또는 변수, 결과가 생성되는 명령문)


---

##### 예제2 (변수 사용 2)

---

```
public class Exam0320 {
  public static void main(String[] args) {
    
    int age1 = 20;

    int age2 = age1;

    age1 = 30;
    
    System.out.println(age1);
    System.out.println(age2);
  }
}
```
> ###### 1. r-value 자리에 변수를 놓을 수 있다.
> ###### 2. age1에 저장된 값을 age2에 복사한다
    - age1과 age2는 같은 메모리가 아니다.
     - age1 값을 변경한 후 실행하면 두 값이 다르다!

---

##### 예제3 (변수 사용 오류 1)

---

```
public class Exam0330 {
  public static void main(String[] args) {
    
    int age;
    
    System.out.println(age);
  }
}
```
> ###### 1. 변수에 값을 저장하지 않은 상태에서 변수를 사용할 수 없다.
     - 값이 저장되지 않은 변수를 사용하면 문법 오류이다

---

##### 예제4 (변수 사용 오류 2)

---
```
public class Exam0340 {
  public static void main(String[] args) {
    
    int age1;
    
    //값이 저장되지 않은 변수를 사용하면 문법 오류이다!
    int age2 = age1;
  }
}
```
> ###### 1. 컴파일 에러가 생긴다!

