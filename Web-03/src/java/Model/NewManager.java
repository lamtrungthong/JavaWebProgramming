/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lds2h
 */
public class NewManager {

    private Connection conn;

    public NewManager() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
    }

    public int countNews() throws SQLException {
        String sql = "SELECT count(*) FROM news ";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);

        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt(1);

    }

    public List getNews(int limit, int offset) throws SQLException {
        String sql = "SELECT * FROM news LIMIT ? OFFSET ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, limit);
        pstmt.setInt(2, offset);
        ResultSet rs = pstmt.executeQuery();
        List<News> list = new ArrayList<>();

        while (rs.next()) {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setImage(rs.getString("image"));
            news.setTitle(rs.getString("title"));
            news.setSummary(rs.getString("summary"));
            news.setContent(rs.getString("content"));
            news.setCreate_at(rs.getString("create_at"));
            news.setAuthor_id(rs.getInt("author_id"));

            list.add(news);
        }

        return list;
    }
    
    public List search(String title, int limit, int offset) throws SQLException{
        String sql = "SELECT * FROM news WHERE title like ? LIMIT ? OFFSET ?";       
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        
        pstmt.setString(1, "%"+title+"%");
        pstmt.setInt(2, limit);
        pstmt.setInt(3, offset);
        
        ResultSet rs = pstmt.executeQuery(); 
        
        List<News> list = new ArrayList<>();

        while (rs.next()) {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setImage(rs.getString("image"));
            news.setTitle(rs.getString("title"));
            news.setSummary(rs.getString("summary"));
            news.setContent(rs.getString("content"));
            news.setCreate_at(rs.getString("create_at"));
            news.setAuthor_id(rs.getInt("author_id"));

            list.add(news);
        }

        return list;
    }
    
    public int countSearch(String title) throws SQLException{
        String sql = "SELECT count(*) FROM news WHERE title like ?";       
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        
        pstmt.setString(1, "%"+title+"%");
        
        ResultSet rs = pstmt.executeQuery();
        
        rs.next();
        return rs.getInt(1);
    }

}
