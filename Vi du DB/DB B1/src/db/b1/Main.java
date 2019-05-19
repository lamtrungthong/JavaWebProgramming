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
import java.util.Scanner;

/**
 *
 * @author lamtrungthong
 */
public class Main {

     public static void bai5(Connection conn) {
        try {
            System.out.println("/* Hiển thị tên, khoa của các độc giả và sắp xếp theo khoa*/");
            PreparedStatement pstmt1 = conn.prepareStatement("select ten, khoa from docgia order by khoa");
            ResultSet rs1 = pstmt1.executeQuery();
            System.out.println("Ten, Khoa");
            System.out.println("==================");
            while (rs1.next()) {
                System.out.println(rs1.getString("ten") + ", " + rs1.getString("khoa"));
                System.out.println("==================");
            }
        } catch (Exception e) {
        }
    }

    public static void bai6(Connection conn) {
        try {
            System.out.println("/* Tim những đọc giả mượn sách Toán vào ngày 1/1/2018*/");
            PreparedStatement pstmt2 = conn.prepareStatement("select docgia.* from docgia join phieumuon "
                    + "on docgia.sothe = phieumuon.sothe join sach on sach.masach  = phieumuon.masach\n"
                    + "where sach.tensach like ? and phieumuon.ngaymuon like ?");
            
            pstmt2.setString(1, "Toan");
            pstmt2.setString(2, "2018-1-1");
            ResultSet rs2 = pstmt2.executeQuery();
            
            
            System.out.println("sothe, ten, khoa, khoahoc, thoihanthe");
            System.out.println("==================");
            while (rs2.next()) {
                System.out.println(rs2.getString("sothe") + ", " + rs2.getString("ten") + ", "
                        + rs2.getString("khoa") + ", " + rs2.getString("khoahoc") + ", "
                        + rs2.getString("thoihanthe"));
                System.out.println("==================");
            }
        } catch (Exception e) {
        }
    }

    public static void bai7(Connection conn) {
        try {
            System.out.println("/* Hiển thị tên, số thẻ, tên sách của tất cả đọc giả "
                    + "mượn sách trong\n" + "tháng 1/2018*/");
            PreparedStatement pstmt3 = conn.prepareStatement("select docgia.ten, docgia.sothe,sach.tensach "
                    + "from docgia join phieumuon on docgia.sothe = phieumuon.sothe "
                    + "join sach on sach.masach = phieumuon.masach\n"
                    + "where year(phieumuon.ngaymuon) = ? and month(phieumuon.ngaymuon) = ?;");
            
            pstmt3.setString(1, "2018");
            pstmt3.setString(2, "1");
            ResultSet rs3 = pstmt3.executeQuery();
            System.out.println(" ten, sothe,tensach");
            System.out.println("==================");
            while (rs3.next()) {
                System.out.println(rs3.getString("docgia.ten") + ", " + rs3.getString("docgia.sothe") + ", "
                        + rs3.getString("sach.tensach"));
                System.out.println("==================");
            }
        } catch (Exception e) {
        }
    }

    public static void bai8(Connection conn) {
        try {
            System.out.println("/* Danh sách các sách không ai mượn*/");
            PreparedStatement pstmt4 = conn.prepareStatement("select * from sach\n"
                    + "where masach not in (select masach  from phieumuon);");
            ResultSet rs4 = pstmt4.executeQuery();
            System.out.println("masach, tensach, tacgia, nxb, soluong");
            System.out.println("==================");
            while (rs4.next()) {
                System.out.println(rs4.getString("masach") + ", " + rs4.getString("tensach") + ", "
                        + rs4.getString("tacgia") + ", " + rs4.getString("nxb") + ", "
                        + rs4.getString("soluong"));
                System.out.println("==================");
            }
        } catch (Exception e) {
        }
    }

    public static void bai9(Connection conn) {
        try {
            System.out.println("/*Cho biết đọc giả tên Anh mượn sách bao nhiêu lần*/");
            PreparedStatement pstmt5 = conn.prepareStatement("select docgia.ten, count(masach) "
                    + "as 'soluong' from phieumuon join docgia on phieumuon.sothe = docgia.sothe\n"
                    + "where docgia.ten like '%?'"
                    + "group by masach;");
            pstmt5.setString(1, "Anh");

            ResultSet rs5 = pstmt5.executeQuery();
            System.out.println("ten, soluong");
            System.out.println("==================");
            while (rs5.next()) {
                System.out.println(rs5.getString("ten") + ", " + rs5.getInt("soluong"));
                System.out.println("==================");
            }
        } catch (Exception e) {
        }
    }

    public static void bai10(Connection conn) {
        try {
            System.out.println("/*Danh sách tên, số thẻ, các độc giả chưa trả sách*/");
            PreparedStatement pstmt6 = conn.prepareStatement("select docgia.ten, docgia.sothe"
                    + " from docgia join phieumuon on docgia.sothe = phieumuon.sothe\n"
                    + "where phieumuon.ghichu like '? %'"
                    + "group by masach;");
            pstmt6.setString(1, "Chua");

            ResultSet rs6 = pstmt6.executeQuery();
            System.out.println("ten, sothe");
            System.out.println("==================");
            while (rs6.next()) {
                System.out.println(rs6.getString("ten") + ", " + rs6.getString("sothe"));
                System.out.println("==================");
            }
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connStr = "jdbc:mysql://localhost:3306/qlythuviien";
            String user = "root";
            String pass = "mysql";
            Connection conn = (Connection) DriverManager.getConnection(connStr, user, pass);
            if (conn != null) {
                System.out.println("Connected");
                System.out.println("=========");
                int menu;
                int ans;
                do {
                    System.out.println("=====MENU=====");
                    System.out.println("1.Bai5");
                    System.out.println("2.Bai6");
                    System.out.println("3.Bai7");
                    System.out.println("4.Bai8");
                    System.out.println("5.Bai9");
                    System.out.println("6.Bai10");

                    System.out.println("Moi ban chon./n");
                    menu = Integer.parseInt(sc.nextLine());
                    switch (menu) {
                        case 1:
                            //5 .
                            bai5(conn);
                            break;
                        case 2:
                            //6 .
                            bai6(conn);
                            break;
                        case 3:
                            //7 .
                            bai7(conn);
                            break;
                        case 4:
                            //8 .
                            bai8(conn);
                            break;
                        case 5:
                            //9 .
                            bai9(conn);
                            break;
                        case 6:
                            //10 .
                            bai10(conn);
                            break;
                        

                    }
                    System.out.println("Tiep tuc 1 / 0?");
                    ans = Integer.parseInt(sc.nextLine());
                } while (ans == 1);
            } else {
                System.out.println("no connect");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
    }

}
