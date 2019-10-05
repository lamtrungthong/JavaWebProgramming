/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import project.config.EncriptPasswdByMD5;
import project.db.ConnectDB;
import project.dto.Info;
import project.dto.Products;
import project.dto.Register;
import project.dto.Users;

/**
 *
 * @author thonglt
 */
public class UserModel {

    Connection conn;

    public UserModel() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
    }

    public void add(Users user) throws SQLException {
        String sql = "INSERT INTO `users`(`id`,`uname`, `pwd`, `actived`, `role_id`) "
                + "VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, user.getId());
        pstmt.setString(2, user.getUsername());
        pstmt.setString(3, EncriptPasswdByMD5.md5(user.getPassword()));
        pstmt.setInt(4, 1);
        pstmt.setInt(5, 3);
        pstmt.executeUpdate();
    }

    public void addInfo(Info info) throws SQLException {
        String sql = "INSERT INTO `info`(`name`, `phone`, `address`, `user_id`) VALUES(?,?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, info.getName());
        pstmt.setString(2, info.getPhone());
        pstmt.setString(3, info.getAddress());
        pstmt.setString(4, info.getUserId());
        pstmt.executeUpdate();
    }

    public int updateInfo(Info info) throws SQLException {
        String sql = "UPDATE `info` SET `name`=?,`phone`=?,`address`=? WHERE user_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, info.getName());
        pstmt.setString(2, info.getPhone());
        pstmt.setString(3, info.getAddress());
        pstmt.setString(4, info.getUserId());
        return pstmt.executeUpdate();
    }

    public Users getUserById(String id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        Users users = null;
        while (rs.next()) {
            users = new Users();
            users.setActived(rs.getInt("actived"));
            users.setCreatedAt(rs.getDate("created_at"));
            users.setUpdatedAt(rs.getDate("updated_at"));
            users.setRoleId(rs.getInt("role_id"));
            users.setId(rs.getString("id"));
            users.setUsername(rs.getString("uname"));
            users.setName(rs.getString("name"));
        }
        return users;
    }

    public Users login(String email, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE uname = ? AND pwd = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        Users users = null;
        while (rs.next()) {
            users = new Users();
            users.setActived(rs.getInt("actived"));
            users.setCreatedAt(rs.getDate("created_at"));
            users.setUpdatedAt(rs.getDate("updated_at"));
            users.setRoleId(rs.getInt("role_id"));
            users.setId(rs.getString("id"));
            users.setUsername(rs.getString("uname"));
        }
        return users;
    }

    public Users getUserByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE uname = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();
        Users users = null;
        while (rs.next()) {
            users = new Users();
            users.setActived(rs.getInt("actived"));
            users.setCreatedAt(rs.getDate("created_at"));
            users.setUpdatedAt(rs.getDate("updated_at"));
            users.setRoleId(rs.getInt("role_id"));
            users.setId(rs.getString("id"));
            users.setUsername(rs.getString("uname"));
        }
        return users;
    }

    public Info getInfoById(String id) throws SQLException {
        String sql = "SELECT * FROM info WHERE user_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        Info info = null;
        while (rs.next()) {
            info = new Info();
            info.setUserId(rs.getString("user_id"));
            info.setName(rs.getString("name"));
            info.setPhone(rs.getString("phone"));
            info.setAddress(rs.getString("address"));
            info.setCreatedAt(rs.getDate("created_at"));
            info.setUpdatedAt(rs.getDate("updated_at"));
        }
        return info;
    }

    public int setPass(String email, String pass) throws SQLException {
        String sql = "UPDATE `users` SET `pwd`= ? WHERE uname = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, EncriptPasswdByMD5.md5(pass));
        pstmt.setString(2, email);
        return pstmt.executeUpdate();
    }

    public int setActived(String id, int actived) throws SQLException {
        String sql = "UPDATE `users` SET `actived`= ? WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, actived);
        pstmt.setString(2, id);
        return pstmt.executeUpdate();
    }

    public int sumUser() throws SQLException {
        String sql = "SELECT COUNT(*) FROM users where id not like ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, "ADMIN");
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public List getAllUser() throws SQLException {
        String sql = "SELECT * FROM users where id not like ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, "ADMIN");
        ResultSet rs = pstmt.executeQuery();
        List<Users> list = new ArrayList<>();
        while (rs.next()) {
            Users u = new Users();
            u.setActived(rs.getInt("actived"));
            u.setCreatedAt(rs.getDate("created_at"));
            u.setUpdatedAt(rs.getDate("updated_at"));
            u.setRoleId(rs.getInt("role_id"));
            u.setId(rs.getString("id"));
            u.setUsername(rs.getString("uname"));
            u.setName(rs.getString("name"));
            list.add(u);
        }
        return list;
    }

    public int delUser(String id) throws SQLException {
        String sql = "DELETE FROM `users` WHERE id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, id);
        return pstmt.executeUpdate();

    }

    public List getUserByLimit(int limit, int offset) throws SQLException {
        String sql = "SELECT * FROM users where id not like ? LIMIT ? OFFSET ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, "ADMIN");
        pstmt.setInt(2, limit);
        pstmt.setInt(3, offset);
        ResultSet rs = pstmt.executeQuery();
        List<Users> list = new ArrayList<>();
        while (rs.next()) {
            Users u = new Users();
            u.setActived(rs.getInt("actived"));
            u.setCreatedAt(rs.getDate("created_at"));
            u.setUpdatedAt(rs.getDate("updated_at"));
            u.setRoleId(rs.getInt("role_id"));
            u.setId(rs.getString("id"));
            u.setUsername(rs.getString("uname"));
            u.setName(rs.getString("name"));
            list.add(u);
        }
        return list;
    }

    public List getAllUserByName(String name) throws SQLException {
        String sql = "SELECT * FROM users WHERE name like  ? ";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, "%" + name + "%");
        ResultSet rs = pstmt.executeQuery();
        List<Users> all = new ArrayList<>();
        while (rs.next()) {
            Users u = new Users();
            u.setActived(rs.getInt("actived"));
            u.setCreatedAt(rs.getDate("created_at"));
            u.setUpdatedAt(rs.getDate("updated_at"));
            u.setRoleId(rs.getInt("role_id"));
            u.setId(rs.getString("id"));
            u.setUsername(rs.getString("uname"));
            u.setName(rs.getString("name"));
            all.add(u);
        }
        return all;
    }
}
