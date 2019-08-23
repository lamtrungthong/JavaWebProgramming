/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.ConnectDB;
import dto.Book;
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
public class BookModel {

    Connection conn;

    public BookModel() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
    }

    //get all book
    public List getBook() throws SQLException {
        String sql = "SELECT * FROM bookmanager";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);

        List<Book> listBooks = new ArrayList<>();
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Book b = new Book();
            b.setId(rs.getInt("id"));
            b.setTitle(rs.getString("title"));
            b.setAuthor(rs.getString("author"));
            b.setPrice(rs.getDouble("price"));
            b.setQuantity(rs.getInt("quantity"));
            listBooks.add(b);
        }

        return listBooks;
    }

    //get book by id
    public Book getBookById(int id) throws SQLException {
        String sql = "SELECT * FROM bookmanager where id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();
        rs.next();
        Book b = new Book();
        b.setId(rs.getInt("id"));
        b.setTitle(rs.getString("title"));
        b.setAuthor(rs.getString("author"));
        b.setPrice(rs.getDouble("price"));
        b.setQuantity(rs.getInt("quantity"));

        return b;
    }

    //add new book
    public int addNewBook(Book book) throws SQLException {
        String sql = "INSERT INTO `bookmanager`(`title`, `author`, `price`, `quantity`) "
                + "VALUES (?,?,?,?)";

        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, book.getTitle());
        pstmt.setString(2, book.getAuthor());
        pstmt.setDouble(3, book.getPrice());
        pstmt.setInt(4, book.getQuantity());

        return pstmt.executeUpdate();
    }
    
    //update book by id 
    
    public int editBookById(Book book) throws SQLException{
        String sql = "UPDATE `bookmanager` SET "
                + "`title`=?,`author`=?,`price`=?,`quantity`=? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        
        pstmt.setString(1, book.getTitle());
        pstmt.setString(2, book.getAuthor());
        pstmt.setDouble(3, book.getPrice());
        pstmt.setInt(4, book.getQuantity());
        pstmt.setInt(5, book.getId());
        
        return pstmt.executeUpdate();
    }

    //delete book by id
    
    public  int deleteBookById(int id) throws SQLException{
        String sql = "DELETE FROM `bookmanager` WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        return pstmt.executeUpdate();
        
    }
}
