/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.b2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lamtrungthong
 */
public class DBConnector {
     public Connection getConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String connStr = "jdbc:mysql://localhost:3307/dblab2quiz";
        Connection conn = DriverManager.getConnection(connStr, "root", "");
        return conn;
    }
}
