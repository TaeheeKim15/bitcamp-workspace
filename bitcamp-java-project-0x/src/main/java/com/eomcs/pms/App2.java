package com.eomcs.pms;

import java.sql.Date;


public class App2 {

  public static void main(String[] args) {
    class Project {
      int no;
      String title;
      String content;
      Date startDate;
      Date endDate;
      String owner;
      String member;
    }

    java.util.Scanner keyInput = new java.util.Scanner(System.in);

    // 여러 개의 프로젝트 정보를 입력 받기 위해 변수 준비
    final int LENGTH = 10;
    Project[] project = new Project[LENGTH];



    System.out.println("[프로젝트]");

    int count = 0;


    for (int i = 0; i < LENGTH; i++) {
      count++;

      Project p = new Project();

      System.out.print("번호? ");
      p.no = keyInput.nextInt();
      keyInput.nextLine();

      System.out.print("프로젝트명? ");
      p.title = keyInput.nextLine();

      System.out.print("내용: ");
      p.content = keyInput.nextLine();

      System.out.print("시작일? ");
      p.startDate = Date.valueOf(keyInput.nextLine());


      System.out.print("종료일? ");
      p.endDate = Date.valueOf(keyInput.nextLine());

      System.out.print("만든이? ");
      p.owner = keyInput.nextLine();

      System.out.println("팀원: ");
      p.member = keyInput.nextLine();
      System.out.println();

      project[i] = p;

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
      Project p = project[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          p.no,
          p.title,
          p.startDate.toString(),
          p.endDate.toString(),
          p.owner);
    }
  }
}






