package com.eomcs.pms.filter;

import java.util.Map;
import com.eomcs.pms.handler.Request;

public class AuthCommandFilter implements CommandFilter {

  // 필터 역할 :
  // - 로그인하지 않은 경우 커맨드를 실행시키지 않는다
  //
  @Override
  public void doFilter(Request request, FilterChain next) throws Exception {
    Map<String, Object> context = request.getContext();
    if (request.getCommandPath().equalsIgnoreCase("/login") || context.get("loginUser") != null) {
      next.doFilter(request);
    } else {
      System.out.println("로그인이 필요합니다.");

    }

  }

}
