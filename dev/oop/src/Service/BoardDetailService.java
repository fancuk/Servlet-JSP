package Service;

import DB.DBConnector;
import Entity.Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BoardDetailService {
    private static BoardDetailService instance = null;
    private Connection conn = null;
    private BoardDetailService(){

    }
    public static BoardDetailService getInstance(){
        if(instance==null){
            instance = new BoardDetailService();
        }
        return instance;
    }
    public Board getDetailBoard(int id){
        Board board = null;
        String sql = "SELECT * FROM NOTICE WHERE ID=?";
        try{
            conn = DBConnector.getInstance().getConn();
            if(conn==null){
                System.out.println("Connection Fail!");
                return null;
            }
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,id); // 첫 번째 물음표에 id 넣기
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int _id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String date = resultSet.getString("date");
                int views = resultSet.getInt("views");
                String content = resultSet.getString("content");
                board = new Board(_id,title,author,date,views,content);
            }
            resultSet.close();
            preparedStatement.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return board;
    }
}
