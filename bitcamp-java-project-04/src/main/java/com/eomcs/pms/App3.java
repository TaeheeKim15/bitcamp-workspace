package com.eomcs.pms;

import java.sql.Date;

public class App3 {

  public static void main(String[] args) {

    java.util.Scanner keyInput = new java.util.Scanner(System.in);

    final int LENGTH = 4;
    String[] project = new String[LENGTH];
    int[] no = new int[LENGTH];
    String[] content = new String[LENGTH];
    Date[] endDate = new Date[LENGTH];
    String[] state = new String[LENGTH];
    String[] worker = new String[LENGTH];

    int count = 0;

    for (int i = 0; i < LENGTH; i++) {
      count++;

      System.out.printf("[%s]\n", "작업");
      System.out.print("프로젝트? ");
      project[i] = keyInput.nextLine();

      System.out.print("번호? ");
      no[i] = keyInput.nextInt();
      keyInput.nextLine();

      System.out.print("내용? ");
      content[i] = keyInput.nextLine();

      System.out.print("완료일? ");
      endDate[i] = Date.valueOf(keyInput.nextLine());


      System.out.print("상태? ");
      System.out.println("0: 신규");
      System.out.println("1: 진행중");
      System.out.println("2: 완료");
      System.out.println("> ");

      state[i] = keyInput.nextLine();

        switch (state[i]) {
          case "0":
            state[i] = "신규";
            break;
          case "1":
            state[i] = "진행중";
            break;
          default:
            state[i] = "완료";
        }



      System.out.print("담당자? ");
      worker[i] = keyInput.nextLine();
      System.out.println();

      System.out.println("계속 입력하시겠습니까?(y/N) ");
      String response = keyInput.nextLine();

      if (!response.equalsIgnoreCase("y"))
        break;

      System.out.println();

    }



    System.out.println("-----------------------");


     System.out.println("프로젝트");

     for(int i = 0; i < count; i++) {
       System.out.printf("%d, %s, %s, %s, %s\n", no[i], content[i], endDate[i].toString(),
           state[i], worker[i] );

       keyInput.close();


//    if (state.equals("0")) {
//      System.out.println("신규");
//    } else if (state.equals("1")) {
//      System.out.println("진행중");
//    } else {
//      System.out.println("완료");
//    }
//    System.out.printf("담당자: %s\n", worker);

    }

  }
}
