package com.eomcs.pms.handler;

import java.util.Map;
import com.eomcs.pms.domain.Member;

// Command 규칙에 따라 클래스를 정의한다.
public class LogoutCommand implements Command {


  @Override
  public void execute(Map<String, Object> context) {
    System.out.println("[로그아웃]");



    try {
      Member loginUser = (Member)context.get("loginUser");
      if (loginUser == null) {
        System.out.println("엥...로그인도 안하셨는데요?");
        return;
      } else {
        // 로그인이 성공했으면 회원 정보를 Map 객체에서 제거한다.
        context.remove("loginUser");
        System.out.printf(" %s 님 빠잉!\n", loginUser.getName());
      }
    } catch (Exception e) {
      System.out.println("로그인 중 오류 발생");
      e.printStackTrace();
    }
  }
}
