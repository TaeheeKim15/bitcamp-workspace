package com.eomcs.pms.handler;

import java.util.Map;
import com.eomcs.pms.dao.MemberDao;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

// Command 규칙에 따라 클래스를 정의한다.
public class LoginCommand implements Command {

  MemberDao memberDao;

  public LoginCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }



  @Override
  public void execute(Map<String, Object> context) {
    System.out.println("[로그인]");

    if(context.get("loginUser") != null) {
      System.out.println("로그인 되어있는데요??? 장난하세요?????");
      return;
    }


    String email = Prompt.inputString("이메일? ");
    String password = Prompt.inputString("암호? ");


    try {
      Member member = memberDao.findByEmailPassword(email, password);
      if (member == null) {
        System.out.println("사용자 정보가 맞지 않네요! ㅠㅠ");
      } else {
        // 로그인이 성공했으면 회원 정보를 context 보관소에 저장한다.
        context.put("loginUser", member);
        System.out.printf(" %s 님 반갑습니당!ㅎㅎ\n", member.getName());
      }
    } catch (Exception e) {
      System.out.println("로그인 중 오류 발생");
      e.printStackTrace();
    }
  }
}
