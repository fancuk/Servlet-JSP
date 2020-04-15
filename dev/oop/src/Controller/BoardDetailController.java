package Controller;

import Entity.Board;
import Service.BoardDetailService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/board/detail")
public class BoardDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // localhost:8080/board/detail?id=n  n 가져오기
        System.out.println("id = " + id);
        Board board = BoardDetailService.getInstance().getDetailBoard(id);
        request.setAttribute("board",board);
        request.getRequestDispatcher("/WEB-INF/view/board/detail.jsp")
                .forward(request,response);
    }
}
