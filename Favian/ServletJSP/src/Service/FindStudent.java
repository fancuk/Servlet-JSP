package Service;

import Entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FindStudent {
    public List<Student> findAllStudent() {
        List<Student> studentList = new ArrayList<Student>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        Properties jdbcProperties = new Properties();
        jdbcProperties.setProperty("user", "root");
        jdbcProperties.setProperty("password", "emforhsqhf1");
        try {
            System.out.println("Test");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Test1");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            System.out.println("Test1");
            String url = "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Seoul&useUnicode=true&characterEncoding=utf8";
            System.out.println(url);
            conn = DriverManager.getConnection(url, jdbcProperties);
            System.out.println("Successfully Connected!");
            String sql = "SELECT * FROM student";
            preparedStatement = conn.prepareStatement(sql);
            System.out.println(preparedStatement.toString());
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                String major = rs.getString("major");
                Student student = new Student(name,major);
                studentList.add(student);
            }
            if(studentList.size()==0)
                System.out.println("아직 정보가 없습니다!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }
}
