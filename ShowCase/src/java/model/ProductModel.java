/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.ConnectDB;
import dto.Product;
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
public class ProductModel {
    Connection conn;

    public ProductModel() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
    }
    
    //get all products
    public List getProd() throws SQLException{
        String sql = "SELECT * FROM products";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        List<Product> listProd = new ArrayList<>();
        while (rs.next()) {            
            Product p = new Product();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setDescription(rs.getString("description"));
            p.setAuthor_id(rs.getInt("author_id"));
            p.setImages(rs.getString("images"));
            p.setActived(rs.getInt("actived"));
            p.setCreate_at(rs.getDate("created_at"));
            p.setUpdated_at(rs.getDate("updated_at"));
            listProd.add(p);
        }
        return listProd;
    }
}
