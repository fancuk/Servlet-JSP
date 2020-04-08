package Service;

import Entity.Student;

import java.sql.*;
import java.util.Properties;

public class CreateStudent {
    public boolean createStudent(String name, String major){
        System.out.println("name = " + name);
        System.out.println("major = " + major);
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        Properties jdbcProperties = new Properties();
        jdbcProperties.setProperty("user", "root");
        jdbcProperties.setProperty("password", "emforhsqhf1");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Seoul&useUnicode=true&characterEncoding=utf8";
            conn = DriverManager.getConnection(url, jdbcProperties);
            System.out.println("Successfully Connected!");
            String sql = "INSERT INTO student(name,major) values(?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,major);
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
            System.out.println("Insert 성공");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                if (rs != null) rs.close();
                if (preparedStatement != null) preparedStatement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
