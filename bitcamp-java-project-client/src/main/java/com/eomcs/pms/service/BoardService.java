package com.eomcs.pms.service;

import java.util.List;
import java.util.Map;
import com.eomcs.pms.domain.Board;

public interface BoardService {

  List<Board> list(Map<String,Object> context) throws Exception;
  int delete(int no) throws Exception;
  Board get(int no) throws Exception;
  int add(Board board) throws Exception;
  int update(Board board) throws Exception;
  List<Board> list(String keyword) throws Exception;
}
