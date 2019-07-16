/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lamtrungthong
 */
public class UserManager {

    Connection conn;

    public UserManager() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
    }

    public boolean checkLogin(String username, String password) throws SQLException {
        String sql = "select * from user where uname = ? and upwd = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
}
