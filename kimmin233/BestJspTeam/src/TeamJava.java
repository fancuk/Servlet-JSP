import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class TeamJava extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<HTML>");
			out.println("<HEAD><TITLE>실습 이후 처음 만든 서블릿</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("그래서 내용은 간단하게,,<BR>");
			for (int cnt=1; cnt<=3; cnt++) {
				for (int star=1; star<=cnt; star++)
					out.print("*");
				out.println("<BR>");
			}
			out.println("</BODY>");
			out.println("</HTML>");
		}
}
