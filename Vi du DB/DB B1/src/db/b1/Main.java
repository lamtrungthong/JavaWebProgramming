/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.b1;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lamtrungthong
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connStr = "jdbc:mysql://localhost:3306/qlythuviien";
            String user = "root";
            String pass = "mysql";
            Connection conn = (Connection) DriverManager.getConnection(connStr, user, pass);
            if (conn != null) {
                System.out.println("Connected");
                System.out.println("=========");
               
                //5 .
                System.out.println("/* Hiển thị tên, khoa của các độc giả và sắp xếp theo khoa*/");
                PreparedStatement pstmt1 = conn.prepareStatement("select ten, khoa from docgia order by khoa");
                ResultSet rs1 = pstmt1.executeQuery();
                System.out.println("Ten, Khoa" );
                System.out.println("==================");
                while (rs1.next()) {         
                    System.out.println(rs1.getString("ten")+", "+rs1.getString("khoa"));
                    System.out.println("==================");
                }
                
                //6
                System.out.println("/* Tim những đọc giả mượn sách Toán vào ngày 1/1/2018*/");
                PreparedStatement pstmt2 = conn.prepareStatement("select docgia.* from docgia join phieumuon "
                        + "on docgia.sothe = phieumuon.sothe join sach on sach.masach  = phieumuon.masach\n" +
                        "where sach.tensach like 'Toan' and phieumuon.ngaymuon like '2018-01-01'");
                ResultSet rs2 = pstmt2.executeQuery();
                System.out.println("sothe, ten, khoa, khoahoc, thoihanthe" );
                System.out.println("==================");
                while (rs2.next()) {         
                    System.out.println(rs2.getString("sothe")+", "+rs2.getString("ten")+", "+
                            rs2.getString("khoa")+", "+rs2.getString("khoahoc") + ", "+
                            rs2.getString("thoihanthe"));
                    System.out.println("==================");
                }
                //7
                System.out.println("/* Hiển thị tên, số thẻ, tên sách của tất cả đọc giả "
                        + "mượn sách trong\n" +"tháng 1/2018*/");
                PreparedStatement pstmt3 = conn.prepareStatement("select docgia.ten, docgia.sothe,sach.tensach "
                        + "from docgia join phieumuon on docgia.sothe = phieumuon.sothe "
                        + "join sach on sach.masach = phieumuon.masach\n" +
                        "where year(phieumuon.ngaymuon) = 2018 and month(phieumuon.ngaymuon) = 1;");
                ResultSet rs3 = pstmt3.executeQuery();
                System.out.println(" ten, sothe,tensach" );
                System.out.println("==================");
                while (rs3.next()) {         
                    System.out.println(rs3.getString("docgia.ten")+", "+rs3.getString("docgia.sothe")+", "+
                            rs3.getString("sach.tensach"));
                    System.out.println("==================");
                }
                //8
                System.out.println("/* Danh sách các sách không ai mượn*/");
                PreparedStatement pstmt4 = conn.prepareStatement("select * from sach\n" +
                "where masach not in (select masach  from phieumuon);");
                ResultSet rs4 = pstmt4.executeQuery();
                System.out.println("masach, tensach, tacgia, nxb, soluong" );
                System.out.println("==================");
                while (rs4.next()) {         
                    System.out.println(rs4.getString("masach")+", "+rs4.getString("tensach")+", "+
                            rs4.getString("tacgia")+", "+rs4.getString("nxb") + ", "+
                            rs4.getString("soluong"));
                    System.out.println("==================");
                }
                
                //9
                System.out.println("/*Cho biết đọc giả tên Anh mượn sách bao nhiêu lần*/");
                PreparedStatement pstmt5 = conn.prepareStatement("select docgia.ten, count(masach) "
                 + "as 'soluong' from phieumuon join docgia on phieumuon.sothe = docgia.sothe\n" +
                 "where docgia.ten like '%Anh'" +
                  "group by masach;");
                ResultSet rs5 = pstmt5.executeQuery();
                System.out.println("ten, soluong" );
                System.out.println("==================");
                while (rs5.next()) {         
                    System.out.println(rs5.getString("ten")+", "+rs5.getInt("soluong"));
                    System.out.println("==================");
                }
                //10
                System.out.println("/*Danh sách tên, số thẻ, các độc giả chưa trả sách*/");
                PreparedStatement pstmt6 = conn.prepareStatement("select docgia.ten, docgia.sothe"
                        + " from docgia join phieumuon on docgia.sothe = phieumuon.sothe\n" +
                    "where phieumuon.ghichu like 'Chua %'" +
                  "group by masach;");
                ResultSet rs6 = pstmt6.executeQuery();
                System.out.println("ten, sothe" );
                System.out.println("==================");
                while (rs6.next()) {         
                    System.out.println(rs6.getString("ten")+", "+rs6.getString("sothe"));
                    System.out.println("==================");
                }
            }else
            {
                System.out.println("no connect");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
    }

}
