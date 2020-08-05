package com.eomcs.pms;

import java.sql.Date;

public class App3 {

  public static void main(String[] args) {
    class Task {
      String project;
      int no;
      String content;
      Date endDate;
      String state;
      String worker;
    }

    java.util.Scanner keyInput = new java.util.Scanner(System.in);

    final int LENGTH = 4;
    Task[] task = new Task[LENGTH];

    long currentMillis = 0;
    int count = 0;

    for (int i = 0; i < LENGTH; i++) {
      count++;

      Task t = new Task();

      System.out.printf("[%s]\n", "작업");
      System.out.print("프로젝트? ");
      t.project = keyInput.nextLine();

      System.out.print("번호? ");
      t.no = keyInput.nextInt();
      keyInput.nextLine();

      System.out.print("내용? ");
      t.content = keyInput.nextLine();

      System.out.print("완료일? ");
      t.endDate = Date.valueOf(keyInput.nextLine());


      System.out.print("상태? ");
      System.out.println("0: 신규");
      System.out.println("1: 진행중");
      System.out.println("2: 완료");
      System.out.println("> ");

      t.state = keyInput.nextLine();

        switch (t.state) {
          case "0":
            t.state = "신규";
            break;
          case "1":
            t.state = "진행중";
            break;
          default:
            t.state = "완료";
        }



      System.out.print("담당자? ");
      t.worker = keyInput.nextLine();
      System.out.println();

      task[i] = t;

      System.out.println("계속 입력하시겠습니까?(y/N) ");
      String response = keyInput.nextLine();

      if (!response.equalsIgnoreCase("y"))
        break;

      System.out.println();

    }



    System.out.println("-----------------------");


     System.out.println("프로젝트");

     for(int i = 0; i < count; i++) {
       Task t = task[i];
       System.out.printf("%d, %s, %s, %s, %s\n",
           t.no,
           t.content,
           t.endDate.toString(),
           t.state,
           t.worker );

       keyInput.close();

    }

  }
}
