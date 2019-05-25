package db.b2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Student
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student st = new Student();
        Scanner sc = new Scanner(System.in);
        String ans;
        List<String> listarr = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String conn = "jdbc:mysql://localhost:3307/dbLab2Quiz";
            Connection connection = (Connection) DriverManager.getConnection(conn, "root", "");

            if (connection != null) {
                System.out.println("Connected");

                //đăng nhập
                System.out.println("QIUZ ONLINE");
                System.out.println("Who are you? ");
                st.name = sc.nextLine();
                System.out.println("----------------");
                System.out.print("Enter email: ");
                st.email = sc.nextLine();
                System.out.print("Enter pass: ");
                st.pass = sc.nextLine();
                //Kiểm tra đăng nhập
                PreparedStatement pstmt = connection.prepareStatement("select * from student where email = ? and pass = ?");
                pstmt.setString(1, st.email);
                pstmt.setString(2, st.pass);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next() == false) {
                    System.exit(0);
                } else {
                    System.out.println("----------------");
                    System.out.println("Welcom: " + st.name);
                    System.out.println("---------START---------");
                    //lấy câu hỏi
                    Statement stmt1 = (Statement) connection.createStatement();
                    ResultSet rs1 = stmt1.executeQuery("select * from questions");
                    int stt = 1;
                    while (rs1.next()) {
                        System.out.println("Câu "+stt);
                        System.out.println(rs1.getString("content"));
                        System.out.println("a) " + rs1.getString("answer_a"));
                        System.out.println("b) " + rs1.getString("answer_b"));
                        System.out.println("c) " + rs1.getString("answer_c"));
                        System.out.println("d) " + rs1.getString("answer_d"));
                        System.out.print("Your answer: ");
                        ans = sc.nextLine();
                        listarr.add(ans);
                        stt++;
                    }
                    //lấy đáp án
                    Statement stmt2 = (Statement) connection.createStatement();
                    ResultSet rs2 = stmt2.executeQuery("select correct from questions");

                    int result = 0;
                    //Kiểm tra đáp án
                    System.out.println("-----------YOUR ANSWER------");
                    for (String listarr1 : listarr) {
                        rs2.next();
                        // System.out.println(rs2.getString("correct"));
                        if (listarr1.equals(rs2.getString("correct"))) {
                            result++;
                        }
                    }
                    System.out.println("Congratulation!");
                    System.out.println("Your result " + result + "/10");
                }
            } else {
                System.out.println("No connected");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        // TODO code application logic here
    }

}
