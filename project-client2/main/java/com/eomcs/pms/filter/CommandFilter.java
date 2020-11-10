package com.eomcs.pms.filter;

import java.util.Map;
import com.eomcs.pms.handler.Request;

// 역할:
// - 필터를 실행할 때 호출하는 메서드 규칙을 정의한다.
//
public interface CommandFilter {
  // 기존 구현체 에 영향을 주지 않고 새 규칙을 추가하는 방법
  // => default 메서드로 선언하라!
  // 우리 오늘부터 1일 ! -> 나 배고파.. -> 우리 밥먹자 귀염둥이! (예외 처리해줌)
  default void init(Map<String,Object> context) throws Exception {};

  void doFilter(Request request, FilterChain next) throws Exception;

  // 우리 헤어져 -> 나 배고파... -> 어쩌라고? (예외 처리안해줌)
  default void destroy() {}

}
