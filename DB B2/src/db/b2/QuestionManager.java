/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.b2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lamtrungthong
 */
public class QuestionManager {
    
    private Connection conn = null;
    public QuestionManager() throws ClassNotFoundException, SQLException {
        this.conn = new DBConnector().getConnect();
    }
   
    public List<Question> getQuestions() throws ClassNotFoundException, SQLException {
        // 1 . ket noi db
        // 2 . tao cau truy van query
        String query =  "SELECT * FROM questions";
        // 3 . thuc thi cau truy van query
        Statement stmt = this.conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        // 4 . duyet ket qua va add vao list
        List<Question> list = new ArrayList<>();
        while (rs.next()) {
            Question q = new Question();
            q.setId(rs.getInt("id"));
            q.setContent(rs.getString("content"));
            q.setAnswerA(rs.getString("answer_a"));
            q.setAnswerB(rs.getString("answer_b"));
            q.setAnswerC(rs.getString("answer_c"));
            q.setAnswerD(rs.getString("answer_d"));
            q.setCorrect(rs.getString("correct"));
            list.add(q);
        }
        return list;
    }
}
