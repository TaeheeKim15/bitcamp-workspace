package com.eomcs.pms.filter;

import com.eomcs.pms.handler.Request;

// 필터가 필터 관리자를 실행시킬 때 호출하는 메서드 규칙
// - 즉, 다음 필터를 실행해달라고 요청할 때 호출하는 메서드 규칙
public interface FilterChain {
  void doFilter(Request request)  throws Exception;

}
