package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.service.MemberService;

public class MemberListCommand implements Command {

  MemberService memberService;

  public MemberListCommand(MemberService memberService) {
    this.memberService = memberService;
  }

  @Override
  public void execute(PrintWriter out, BufferedReader in, Map<String,Object> context) {
    out.println("[회원 목록]");
    try {
      List<Member> list = memberService.list();
      for (Member member : list) {
        out.printf("%d, %s, %s, %s, %s\n",
            member.getNo(),
            member.getName(),
            member.getEmail(),
            member.getTel(),
            member.getRegisteredDate());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



}
