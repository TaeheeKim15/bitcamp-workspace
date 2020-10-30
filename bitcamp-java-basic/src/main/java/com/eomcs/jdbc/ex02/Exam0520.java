// auto commit의 문제점
package com.eomcs.jdbc.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam0520 {
  public static void main(String[] args){
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

      // 한 단위로 수행해야 할 작업이 있다면,
      // commit 할 때까지 실제 테이블에 적용하지 않도록
      // auto comit을 취소하고 수동 commit 상태로 만든다.
      con.setAutoCommit(false);


      // 게시글 입력
      boardStmt.setString(1, title);
      boardStmt.setString(2, contents);
      int fileCount = boardStmt.executeUpdate();
      System.out.printf("%d 개 게시글 입력 성공!", fileCount);


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
        fileStmt.executeUpdate();
        fileCount++;
      }
      System.out.printf("%d 개 첨부파일 입력 성공!\n", fileCount);

      // 자식 테이블의 데이터까지 정상적으로 입력했다면,
      // DBMS에게 작업 결과르 실제 테이블에 적용하라고 요청한다.

      con.commit();

    } catch (Exception e) {
      System.out.println("게시글 입력 중 오류 발생!");

      // 만약에 입력 도중에 실패했다면,
      // 현재까지 작업한 결과를 모두 취소하라고  DBMS에게 통보한다
      // => commit()을 호출하지 않고
      //    커넥션 객체를 닫으면
      //    DBMS는 그 커넥션을 통해 수행한 모든 작업을 rollback한다.
      // => 따라서 따로 커넥션 객체에 대해 rollback()을 호출할 필요 없다
    }
  }

}
