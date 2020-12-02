package com.eomcs.pms.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.MemberService;

@WebListener
public class AutoLoginListener implements HttpSessionListener {

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    System.out.println("세션 생성되었음! - 자동로그인~!");

    try {
      HttpSession session = se.getSession();
      MemberService memberService = (MemberService) session.getServletContext().getAttribute("memberService");
      Member member = memberService.get("3@naver.com","1111");
      session.setAttribute("loginUser", member);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
