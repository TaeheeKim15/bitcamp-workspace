package com.eomcs.pms;

public class App2 {

  public static void main(String[] args) {
    
    java.util.Scanner keyInput = new java.util.Scanner(System.in);
  
    
    System.out.print("[");
    System.out.print("프로젝트");
    System.out.println("]");

    System.out.print("번호? ");
    int no = keyInput.nextInt();
    // 숫자만 나타내고 싶다면 int
    keyInput.nextLine();

    System.out.print("프로젝트명? ");
    String title = keyInput.nextLine();

    System.out.print("내용: ");
    String content = keyInput.nextLine();
    
    System.out.print("시작일? ");
    java.sql.Date startDate = java.sql.Date.valueOf(keyInput.nextLine());
    
    
    System.out.print("종료일? ");
    java.sql.Date endDate =java.sql.Date.valueOf(keyInput.nextLine());

    System.out.print("만든이? ");
    String maker = keyInput.nextLine();
    
    System.out.println("팀원: ");
    String member = keyInput.nextLine();
    
    keyInput.close();
    
    System.out.println("-------------------");
    System.out.printf("번호: %d\n", no);
    System.out.printf("프로젝트명: %s\n", title);
    System.out.printf("내용: %s\n", content);
    System.out.printf("시작일: %s\n", startDate);
    System.out.printf("종료일: %s\n", endDate);
    System.out.printf("만든이: %s\n", maker);
    System.out.printf("팀원: %s\n", member);
    
         
  }
}
