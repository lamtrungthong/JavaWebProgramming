/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lamtrungthong
 */
public class RegisterManager {
    Connection conn;

    public RegisterManager() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
    }
    
    public int addRegister(Register register) throws SQLException{
        String sql = "INSERT INTO user(uname, upwd, email, fname, address) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, register.getUsername());
        pstmt.setString(2, register.getPassword());
        pstmt.setString(3, register.getEmail());
        pstmt.setString(4, register.getFullname());
        pstmt.setString(5, register.getAddress());
        
        return pstmt.executeUpdate();
    }
    
    
}
