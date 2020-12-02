package com.eomcs.pms.web;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.service.BoardService;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 서블릿 컨텍스트를 request 통해서 알아낸다.
    ServletContext ctx = request.getServletContext();
    // 서버가 시작될 때 @WebListener으로 시작된 DataHandlerListene에서 exx.getAttribute 를 꺼낸다.
    BoardService boardService = (BoardService) ctx.getAttribute("boardService");

    try {
      Board board = new Board();
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));
      int count = boardService.update(board);

      if (count == 0) {
        throw new Exception("<p>해당 번호의 게시글이 없습니다.</p>");
      }

      // 정상적으로 실행됐다면
      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error").forward(request, response);
      return;
    }
  }
}
