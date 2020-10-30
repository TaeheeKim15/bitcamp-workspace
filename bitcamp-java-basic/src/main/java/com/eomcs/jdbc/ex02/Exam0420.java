package com.eomcs.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam0420 {
  public static void main(String[] args) throws Exception {
    String title = null;
    String contents = null;
    ArrayList<String> files = new ArrayList<>();

    try (Scanner keyScan = new Scanner(System.in)) {

      System.out.print("제목? ");
      title = keyScan.nextLine();

      System.out.print("내용? ");
      contents = keyScan.nextLine();

      // 사용자로부터 첨부파일 입력받기
      while (true) {
        System.out.print("첨부파일: (완료는 그냥 엔터!)");
        String filename = keyScan.nextLine();
        if (filename.length() == 0) {
          break;
        }
        files.add(filename);
      }
    }

    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        // => 게시글을 입력할 때 자동 생성된 PK 값을 받겠다고 설정한다.
        PreparedStatement boardStmt = con.prepareStatement("insert into x_board(title, contents) values(?,?)",
            Statement.RETURN_GENERATED_KEYS);

        // 첨부 파일 입력 처리 객체
        PreparedStatement fileStmt = con.prepareStatement("insert into x_board(file_path, board_id) values(?,?)")) {

      // 게시글 입력
      boardStmt.setString(1, title);
      boardStmt.setString(2, contents);
      int fileCount = boardStmt.executeUpdate();
      System.out.printf("%d 개 게시글 입력 성공!", fileCount);

      // 위에서 입력한 게시글의 PK값을 알아내기
      ResultSet keyRS = boardStmt.getGeneratedKeys();
      keyRS.next(); // PK가 들어 있는 레코드를 한 개 가져온다.
      int boardId = keyRS.getInt(1);

      // 첨부파일 입력
      for (String filename : files) {
        fileStmt.setString(1, filename);

        // 위에서 게시글 입력 후에 자동 생성된 PK값을 사용한다.
        fileStmt.setInt(2,  boardId);

        fileStmt.executeUpdate();
        fileCount++;
        // 첨부파일 테이블에 데이터를 입력하려면
        // 게시글 테이블의 게시글 번호를 알아야 한다
        // 문제는 바로 위에서 입력한 게시글의 PK가 자동 생송되는 컬럼이기 때문에
        // 입력한 수 그 PK값이 뭔지 알 수가 없다는 것이다
        // 그래서 첨부 파일 테이블에 데이터를 입력할 수 없다
        // 해결책!
        // -    데이터를 입력할 때 자동 생성된 PK값을 알 수 있다면
        //      이 문제를 해결할 수 있다.
        // -    다음 예제를 확인해보자!
        //
        fileStmt.executeUpdate();
        fileCount++;
      }
      System.out.printf("%d 개 첨부파일 입력 성공!\n", fileCount);
    }
  }

}
