package com.eomcs.pms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;

public class BoardListCommand implements Command {

  BoardService boardService;

  public BoardListCommand(BoardService boardService) {
    this.boardService = boardService;
  }


  @Override
  public void execute(PrintWriter out, BufferedReader in, Map<String,Object> context) {
    out.println("[게시물 목록]");
    try {

      List<Board> list = boardService.list();

      out.println("번호, 제목, 작성자, 등록일, 조회수");

      for (Board board : list) {
        out.printf("%d, %s, %s, %s, %d\n",
            board.getNo(),
            board.getTitle(),
            board.getWriter(),
            board.getRegisteredDate(),
            board.getViewCount());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
