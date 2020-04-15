package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnector {
    private static DBConnector instance = null;
    private Connection conn = null;
    private DBConnector(){

    }
    public static DBConnector getInstance(){
        if(instance==null){
            instance = new DBConnector();
        }
        return instance;
    }
    public Connection getConn(){
        try{
            Properties jdbcProperties = new Properties();
            jdbcProperties.setProperty("user", "root");
            jdbcProperties.setProperty("password", "emforhsqhf1");
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Seoul&useUnicode=true&characterEncoding=utf8";
            conn = DriverManager.getConnection(url, jdbcProperties);
            System.out.println("Successfully Connected!");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
