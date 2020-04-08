package Servlet;

import Entity.Student;
import Service.FindStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/list")
public class StudentList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FindStudent findStudent = new FindStudent();
        List<Student> studentList = findStudent.findAllStudent();
        request.setAttribute("sl",studentList);
        request.setAttribute("count",studentList.size());
        request.
                getRequestDispatcher("/WEB-INF/view/student/example.jsp").
                forward(request, response);
    }
}
