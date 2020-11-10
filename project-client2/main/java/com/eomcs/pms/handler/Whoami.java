package com.eomcs.pms.handler;

import java.util.Map;
import com.eomcs.pms.domain.Member;

// Command 규칙에 따라 클래스를 정의한다.
public class Whoami implements Command {




  @Override
  public void execute(Map<String, Object> context) {



    try {
      Member member = (Member)context.get("loginUser");
      if (member == null) {
        System.out.println("엥??로그인 안했는데요?!");
        return;
      } else {
        // 로그인이 성공했으면 회원 정보를 context 보관소에 저장한다.
        context.put("whoami", member);
        System.out.printf(" 사용자 번호 :%d\n", member.getNo());
        System.out.printf(" 이메일 : %s \n", member.getEmail());
        System.out.printf(" 사진 : %s\n", member.getPhoto());
        System.out.printf(" 전화 : %s\n", member.getTel());
      }
    } catch (Exception e) {
      System.out.println("Who am I? 도중 오류 발생");
      e.printStackTrace();
    }
  }
}
