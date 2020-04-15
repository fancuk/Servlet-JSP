package Service;

import DB.DBConnector;
import Entity.Board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BoardListService {
    private static BoardListService instance = null;
    private Connection conn = null;
    private BoardListService() {

    }

    public static BoardListService getInstance() {
        if (instance == null) {
            instance = new BoardListService();
        }
        return instance;
    }

    public int getBoardsCount(String field, String query){
        int count = 0;
        String sql = "SELECT COUNT(ID) AS COUNT FROM " + "(SELECT @ROWNUM:=@ROWNUM+1 AS ROWNUM, N.* FROM "
                + "(SELECT * FROM NOTICE WHERE " + field + " LIKE ? ORDER BY REGDATE DESC) N, "
                + "(SELECT @ROWNUM := 0)R ) NN";
        try{
            conn = DBConnector.getInstance().getConn();
            if(conn==null){
                System.out.println("Connection Fail!");
                return 0;
            }
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "%" + query + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                count = resultSet.getInt("count");
            }
            resultSet.close();
            preparedStatement.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    public List<Board> getBoardList(String field, String query, int page) {
        List<Board> boardList = new ArrayList<>();
        String sql = "SELECT * FROM ( " + "SELECT @ROWNUM:=@ROWNUM+1 AS ROWNUM, N.* FROM "
                + "(SELECT * FROM NOTICE WHERE " + field + " LIKE ? ORDER BY REGDATE DESC) "
                + "N, (SELECT @ROWNUM := 0)R ) NN " + " WHERE ROWNUM BETWEEN ? AND ?";
        try {
            conn = DBConnector.getInstance().getConn();
            if(conn==null){
                System.out.println("Connection Fail!");
                return null;
            }
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "%" + query + "%");
            preparedStatement.setInt(2, 1 + (page - 1) * 10);
            preparedStatement.setInt(3, page * 10);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int _id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String date = resultSet.getString("date");
                int views = resultSet.getInt("views");
                String content = resultSet.getString("content");
                Board board = new Board(_id,title,author,date,views,content);
                boardList.add(board);
            }
            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardList;
    }
}
