package com.eomcs.pms.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.eomcs.pms.domain.Member;

@WebServlet("/auth/loginUser")
public class loginUserServlet extends HttpServlet  {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 클라이언트 전용 보관소(HttpSession)를 준비한다.
    HttpSession session = request.getSession();

    // 클라이언트로 데이터를 출력할 때 사용할 스트림 준비
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head><title>로그인 유저</title></head>");
    out.println("<body>");

    out.println("<h1>로그인 유저</h1>");

    Member member = (Member) session.getAttribute("loginUser");
    if (member == null) {
      out.println("<p>로그인 하지 않았습니다!</p>");
      return;
    }

    out.printf("<p>사용자 번호: %d</p>\n", member.getNo());
    out.printf("<p>이름: %s</p>\n", member.getName());
    out.printf("<p>이메일: %s</p>\n", member.getEmail());
    out.printf("<p>사진: %s</p>\n", member.getPhoto());
    out.printf("<p>전화: %s</p>\n", member.getTel());
    out.printf("<p>등록일: %s</p>\n", member.getRegisteredDate());

    out.println("</body>");
    out.println("</html>");
  }
}