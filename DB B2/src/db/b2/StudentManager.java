/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.b2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.w3c.dom.css.Counter;

/**
 *
 * @author lamtrungthong
 */
public class StudentManager {

    Connection conn;

    public StudentManager() throws ClassNotFoundException, SQLException {
        DBConnector db = new DBConnector();
        this.conn = db.getConnect();
    }

    public Student login(String email, String pass) throws SQLException {
        // 1. Taoj ket noi
        // 2. Thuc hien cau lenh
        String query = "SELECT * FROM student WHERE email = ? AND pass = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setString(1, email);
        pstmt.setString(2, pass);

        ResultSet rs = pstmt.executeQuery();
        Student s = null;
        if (rs.next()) {
            s = new Student(rs.getInt("id"), rs.getString("name"),
                    rs.getString("email"), rs.getString("pass"));
        }

        return s;
    }

    public int addAnswer(Student s, Question q, String answer) throws SQLException {
        String query = "INSERT INTO student_questions VALUES (?,?,?)";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, s.getId());
        pstmt.setInt(2, q.getId());
        pstmt.setString(3, answer);
        return pstmt.executeUpdate();
    }

    public int updateAnswer(Student s, Question q, String answer) throws SQLException {
        String query = "UPDATE student_questions SET student_id = ?, question_id = ?, answer = ? "
                + "where student_id = ? and question_id = ? ";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, s.getId());
        pstmt.setInt(2, q.getId());
        pstmt.setString(3, answer);
        pstmt.setInt(4, s.getId());
        pstmt.setInt(5, q.getId());
        return pstmt.executeUpdate();
    }

    public String getAnswer(Student s, Question q) throws SQLException {
        String query = "select * from student_questions where student_id = ? and question_id = ? ";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, s.getId());
        pstmt.setInt(2, q.getId());
        ResultSet rs = pstmt.executeQuery();
        String answer = null;
        if (rs.next()) {
           answer =  rs.getString("answer");
        }
        return answer;
    }

    public void answerQuestion(List<Question> questions, StudentManager sm, Scanner input, Student s, int countCorr) throws SQLException {
        countCorr = 0;
        int index = 1;
        for (Question q : questions) {
            System.out.printf("Question %d/%d \n", index++, questions.size());
            System.out.println(q);
            System.out.print("Your answer > ");
            String answer = input.nextLine();
            sm.addAnswer(s, q, answer);
            if (answer.toLowerCase().equals(q.getCorrect().toLowerCase())) {
                countCorr++;
            }
        }
    }

    public boolean isResult(Student s) throws SQLException {

        String query = "select * from student_questions where student_id = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(query);
        pstmt.setInt(1, s.getId());
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }

    public void printResult(List<Question> questions, Student s) throws SQLException {
        int index = 1;
        for (Question q : questions) {
            System.out.printf("Question %d/%d \n", index++, questions.size());
            System.out.println(q);
            System.out.print("Your answer > " + getAnswer(s, q));
            System.out.println("");
        }

    }

}
