package com.eomcs.pms.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 서로 다른 서블릿이 같은 주소를 가질 수가 없다

// 필터 역할:
// - 로그인 하지 않은 경우 커맨드를 실행시키지 않는다.
// - 로그인이 잠시 막아두고 싶다면 애노테이션을 주석으로 막아라
@WebFilter("/*")
public class AuthFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;
    if (httpRequest.getServletPath().startsWith("/auth") ||
        httpRequest.getServletPath().startsWith(".html") ||
        httpRequest.getServletPath().startsWith(".css") ||
        httpRequest.getServletPath().startsWith(".js") ||
        httpRequest.getServletPath().startsWith(".gif") ||
        httpRequest.getServletPath().startsWith(".jpg") ||
        httpRequest.getServletPath().startsWith(".jpeg") ||
        httpRequest.getServletPath().startsWith(".png") ||
        httpRequest.getSession().getAttribute("loginUser") != null) {
      chain.doFilter(request, response);
    } else {
      // 브라우저가 읽을 때는 서버 루트로 명시해주어야 한다
      // 그러나 절대 경로로 변경되었을 경우에 파일을 찾아가지 못하는 경우가 생긴다

      ServletContext servletContext = request.getServletContext();
      String contextRootPath = servletContext.getContextPath();
      httpResponse.sendRedirect(contextRootPath + "/auth/login.html");
    }
  }
}
