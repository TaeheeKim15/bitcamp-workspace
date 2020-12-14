package com.eomcs.pms.web;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.pms.domain.Member;

@Controller
public class MemberUpdateController {

  @Autowired ServletContext servletContext;

  // 파라미터 이름과 프라퍼티 이름이 같을 때 프론트 컨트롤러가 꼽아준다
  @RequestMapping("/member/update")
  public String execute(Member member) throws Exception {
    memberService.update(member);
    return "redirect:list";
  }
}
