package com.eomcs.pms;

import java.sql.Date;
// Date라는 클래스는 java.sql이라는 패키지에 있다고 컴파일러에게 알려주는 것
// 클래스를 메모리로 가져온다 (X)


public class App2 {

  public static void main(String[] args) {

    java.util.Scanner keyInput = new java.util.Scanner(System.in);

    // 여러 개의 프로젝트 정보를 입력 받기 위해 변수 준비
    final int LENGTH = 10;
    int[] no = new int[LENGTH];
    String[] title = new String[LENGTH];
    String[] content = new String[LENGTH];
    Date[] startDate = new Date[LENGTH];
    Date[] endDate = new Date[LENGTH];
    String[] owner = new String[LENGTH];
    String[] member = new String[LENGTH];
    // 실제 담는 곳은 메모리

    int count = 0;

    System.out.println("[프로젝트]");

    for (int i = 0; i < LENGTH; i++) {
      count++;

      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      // 숫자만 나타내고 싶다면 int
      keyInput.nextLine();

      System.out.print("프로젝트명? ");
      title[i] = keyInput.nextLine();

      System.out.print("내용: ");
      content[i] = keyInput.nextLine();

      System.out.print("시작일? ");
      startDate[i] = java.sql.Date.valueOf(keyInput.nextLine());


      System.out.print("종료일? ");
      endDate[i] =java.sql.Date.valueOf(keyInput.nextLine());

      System.out.print("만든이? ");
      owner[i] = keyInput.nextLine();

      System.out.println("팀원: ");
      member[i] = keyInput.nextLine();
      System.out.println();

      System.out.println("계속 입력하시겠습니까?(y/N) ");
      String response = keyInput.nextLine();

      if (!response.equalsIgnoreCase("y"))
       break;
      // 해석 : 응답이 y가 아니라면 멈춰라

      System.out.println();

    }

    keyInput.close();

    System.out.println("-------------------");

    for (int i = 0; i < count; i++) {
    System.out.printf("%d, %s, %s, %s, %s\n",
        no[i], title[i], startDate[i], endDate[i], owner[i]);
    }
  }
}






