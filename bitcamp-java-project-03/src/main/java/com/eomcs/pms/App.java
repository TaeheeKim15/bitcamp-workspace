package com.eomcs.pms;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    
    // 콘솔에서 사용자의 입력을 처리하는 도구를 준비한다.
    //=> 키보드: input stream: System.in
    //=> input stream에서 data를 읽어 적절한 타입으로 리턴하는 도구: Scanner
    java.util.Scanner keyInput = new java.util.Scanner(System.in);
    
    //=> 입력에서 값을 읽는 도구: Scanner
    /*new java.util.Scanner(System.in);
    new java.io.BufferedInputStream(System.in);
    new java.io.DataInputStream(System.in);
    */
    
    System.out.println("[회원]");
    System.out.print("번호? ");
    int no = keyInput.nextInt(); // nextInt()는 입력 값 중에서 숫자만 뽑아간다.
    keyInput.nextLine(); // 숫자 뒤에 남아 있는 CR/LF 값 읽기
    
    System.out.print("이름? ");
    String name = keyInput.nextLine();
    System.out.println("이메일?");
    String email = keyInput.nextLine();
    System.out.println("암호?");
    String password = keyInput.nextLine();
    System.out.println("사진?");
    String photo = keyInput.nextLine();
    System.out.println("전화?");
    String tel = keyInput.nextLine();
    
    long currentMillis = System.currentTimeMillis();//1970-1-1 00:00:00 에서 경과된 밀리초
    java.sql.Date now = new java.sql.Date(currentMillis);
    
    
   
    keyInput.close();
    
    System.out.println("-------------------------");
    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %s\n", password);
    System.out.printf("사진: %s\n", photo);
    System.out.printf("전화: %s\n", tel);
    System.out.printf("가입일: %s\n", now.toString());
        
  }
}

// 자바에서 명령은 직접할 수 없다
// 자바에 데이터를 꼽아서 써야 된다
// 자바 리모콘~~
