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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lamtrungthong
 */
public class StudentManager {
    Connection conn ;

    public StudentManager() throws ClassNotFoundException, SQLException {
        this.conn = new ConnectDB().getConnection();
    }
    
    public List getStudent() throws SQLException{
        List<Student> list = new ArrayList<>();
        String sql = "select * from student";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        ResultSet rs =  pstmt.executeQuery();
        
        while (rs.next()) {            
            Student st = new Student();
            st.setId(rs.getInt("id"));
            st.setHoTen(rs.getString("hoten"));
            st.setKhoa(rs.getString("khoa"));
            st.setLop(rs.getString("lop"));
            
            list.add(st);
        }
        
        return list;
    }
    
    public Student getStudentByID(int id) throws SQLException{
    String sql = "select * from student where id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs =  pstmt.executeQuery();
        Student st = new Student();
        while (rs.next()) {            
            
        st.setId(rs.getInt("id"));
        st.setHoTen(rs.getString("hoten"));
        st.setKhoa(rs.getString("khoa"));
        st.setLop(rs.getString("lop"));
        }
        
        
        return st;
    }
    
    public int addStudent(Student st) throws SQLException{
        String sql = "INSERT INTO `student`(`hoten`, `khoa`, `lop`) VALUES (?,?,?)";
        
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, st.getHoTen());
        pstmt.setString(2, st.getKhoa());
        pstmt.setString(3, st.getLop());
        
        return pstmt.executeUpdate();
    }
    
    public int deleteStudent(int id) throws SQLException{
        String sql = "DELETE FROM student where id = ?";
        
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        int rs = pstmt.executeUpdate();
        return rs;
    }
    
    public int updateStudent(Student st) throws SQLException{
        String sql = "UPDATE `student` SET `hoten`=?,`khoa`=?,`lop`=? WHERE id = ?";
        
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, st.getHoTen());
        pstmt.setString(2, st.getKhoa());
        pstmt.setString(3, st.getLop());
        pstmt.setInt(4, st.getId());
        
        int rs = pstmt.executeUpdate();
        return rs;
    
    }
    
    
}
