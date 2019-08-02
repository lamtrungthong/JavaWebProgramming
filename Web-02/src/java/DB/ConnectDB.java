/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lamtrungthong
 */
public class ConnectDB {
    public Connection getConnection() throws ClassNotFoundException, SQLException{ 
        Class.forName("com.mysql.jdbc.Driver");
        String connStr = "jdbc:mysql://localhost:3307/web02";
        Connection conn = DriverManager.getConnection(connStr, "root", "");
        
        return conn;
    }
}
