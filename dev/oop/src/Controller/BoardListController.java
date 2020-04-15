package Controller;

import Entity.Board;
import Service.BoardListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/board/list")
public class BoardListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String field = request.getParameter("field");
        String query = request.getParameter("query");
        String page = request.getParameter("page");
        if(field == null || field.equals("")) {
            field = "title";
        }
        if(query == null || query.equals("")) {
            query = "";
        }
        if(page==null || page.equals("")) {
            page = "1";
        }
        List<Board> boards = BoardListService.getInstance().getBoardList(field,query,Integer.parseInt(page));
        int count = BoardListService.getInstance().getBoardsCount(field,query);
        request.setAttribute("boards",boards);
        request.setAttribute("count",count);
        request.getRequestDispatcher("/WEB-INF/view/board/list.jsp")
                .forward(request,response);
    }
}
