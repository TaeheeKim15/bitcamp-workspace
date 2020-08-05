package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class Appp {
  static Scanner keyInput = new Scanner(System.in);

  // 회원
  static final int LENGTH = 10;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] now = new Date[LENGTH];
  static long currentMillis = 0;
  static int count = 0;

  // 프로젝트

  static final int PLENGTH = 10;
  static int[] pno = new int[PLENGTH];
  static String[] ptitle = new String[PLENGTH];
  static String[] pcontent = new String[PLENGTH];
  static Date[] pstartDate = new Date[PLENGTH];
  static Date[] pendDate = new Date[PLENGTH];
  static String[] powner = new String[PLENGTH];
  static String[] pmember = new String[PLENGTH];
  static int pcount = 0;

  // 작업

  static final int TLENGTH = 4;
  static String[] tproject = new String[TLENGTH];
  static int[] tno = new int[TLENGTH];
  static String[] tcontent = new String[TLENGTH];
  static Date[] tendDate = new Date[TLENGTH];
  static String[] tstate = new String[TLENGTH];
  static String[] tworker = new String[TLENGTH];

  static int tcount = 0;

  public static void main(String[] args) {




    loop:
      while (true) {
        System.out.print("명령> ");
        String command = keyInput.nextLine();

        switch (command.toLowerCase()) {
          case "/member/add":
            addMember();
            break;
          case "/member/list":
            listMember();
            break;
          case "/project/add":
            addProject();
            break;

          case "/project/list":
            listProject();
            break;

          case "/task/add":
            addTask();
            break;

          case "/task/list":
            listTask();
            break;
          case "exit":
          case "quit":
            System.out.println("안녕!");
            break loop;
          default:
            System.out.println("실행할 수 없는 명령입니다.");
        }

        System.out.println();

      }

    keyInput.close();

    System.out.println("종료!");
  }



  static void addMember() {
    System.out.println("[회원등록]");

    String input = Integer.parseInt(prompt("번호? "));
    no[count] = Integer.parseInt(input);

    System.out.print("이름? ");
    name[count] = keyInput.nextLine();

    System.out.print("이메일? ");
    email[count] = keyInput.nextLine();

    System.out.print("암호? ");
    password[count] = keyInput.nextLine();

    System.out.print("사진? ");
    photo[count] = keyInput.nextLine();

    System.out.print("전화? ");
    tel[count] = keyInput.nextLine();

    currentMillis = System.currentTimeMillis(); // 1970-1-1 00:00:00 에서경과된 밀리초
    now[count] = new Date(currentMillis);

    count++;
  }

  static void listMember() {
    System.out.println("[회원 목록]");

    for (int i = 0; i < count; i++) {

      System.out.printf("%d, %s, %s, %s, %s\n", no[i], name[i], email[i], tel[i], now[i].toString());
    }
  }

  static void addProject() {

    System.out.println("[프로젝트 등록]");

    System.out.print("번호? ");
    pno[pcount] = keyInput.nextInt();
    // 숫자만 나타내고 싶다면 int
    keyInput.nextLine();

    System.out.print("프로젝트명? ");
    ptitle[pcount] = keyInput.nextLine();

    System.out.print("내용: ");
    pcontent[pcount] = keyInput.nextLine();

    System.out.print("시작일? ");
    pstartDate[pcount] = java.sql.Date.valueOf(keyInput.nextLine());


    System.out.print("종료일? ");
    pendDate[pcount] =java.sql.Date.valueOf(keyInput.nextLine());

    System.out.print("만든이? ");
    powner[pcount] = keyInput.nextLine();

    System.out.println("팀원: ");
    pmember[pcount] = keyInput.nextLine();

    pcount++;

  }

  static void listProject() {
    System.out.println("[프로젝트 목록]");

    for (int i = 0; i < pcount; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          pno[i], ptitle[i], pstartDate[i], pendDate[i], powner[i]);
    }

  }

  static void addTask() {
    System.out.println("[작업 등록]");


    System.out.print("번호? ");
    tno[tcount] = keyInput.nextInt();
    keyInput.nextLine();

    System.out.print("내용? ");
    tcontent[tcount] = keyInput.nextLine();

    System.out.print("완료일? ");
    tendDate[tcount] = Date.valueOf(keyInput.nextLine());


    System.out.println("상태? ");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    System.out.println("> ");

    tstate[tcount] = keyInput.nextLine();

    switch (tstate[tcount]) {
      case "0":
        tstate[tcount] = "신규";
        break;
      case "1":
        tstate[tcount] = "진행중";
        break;
      default:
        tstate[tcount] = "완료";
    }



    System.out.print("담당자? ");
    tworker[tcount] = keyInput.nextLine();
    System.out.println();

    tcount++;

  }

  static void listTask() {
    System.out.println("[작업 목록]");

    for(int i = 0; i < tcount; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", tno[i], tcontent[i], tendDate[i].toString(),
          tworker[i], tstate[i] );
    }
  }

  static String promptString(String title) {
    System.out.println(title);
    return keyInput.nextLine();
  }

  static int promptInt() {
    System.out.println("명령> ");
    return keyInput.nextLine();
  }

  static Date promptDate() {
    System.out.println("명령> ");
    return keyInput.nextLine();
  }


}









