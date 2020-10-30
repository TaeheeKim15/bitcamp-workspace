package com.eomcs.pms.handler;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.eomcs.util.Prompt;

public class MemberDetailCommand implements Command {



  @Override
  public void execute() {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호? ");


    try (java.sql.Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement(
            "select no, name, email, photo, tel"
                + " from pms_member"
                + " where no = " + no); // sql은 공백 안주는 경우도 있는데

        ResultSet rs = stmt.executeQuery()) {


      if (rs.next()) {
        System.out.printf("이름: %s\n", rs.getString("name"));
        System.out.printf("이메일: %s\n", rs.getString("email"));
        System.out.printf("사진: %s\n", rs.getString("photo"));
        System.out.printf("전화번호: %s\n", rs.getString("tel"));

      } else {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      }
    } catch (Exception e) {
      System.out.println("게시글 조회 중 오류 발생!");
      e.printStackTrace();
    }

  }

}
