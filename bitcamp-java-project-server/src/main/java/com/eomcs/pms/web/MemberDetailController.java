package com.eomcs.pms.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.eomcs.pms.domain.Member;

@Controller
public class MemberDetailController {

  ServletContext servletContext;

  @RequestMapping("/member/detail")
  public ModelAndView execute(int no, HttpServletResponse response) throws Exception {

    Member member = memberService.get(no);
    if (member == null) {
      throw new Exception("해당 회원이 없습니다!");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("member", member);
    mv.setViewName("/member/detail.jsp");
    return mv;
  }
}
