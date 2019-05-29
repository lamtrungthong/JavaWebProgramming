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
        try {
            // TODO code application logic here
            Scanner input = new Scanner(System.in);
            System.out.println("   QUIZ ONLINE   ");
            System.out.println("------------------");
            System.out.print("Enter Email: ");
            String email = input.nextLine();

            System.out.print("Enter Pass: ");
            String pass = input.nextLine();

            StudentManager sm = new StudentManager();
            Student s = sm.login(email, pass);

            if (s != null) {
                QuestionManager qm = new QuestionManager();
                List<Question> questions = qm.getQuestions();
                if (sm.isResult(s)) {
                    System.out.println("YOU HAVE COMPLETED THE TEST.\n"
                            + "DO YOU WANT TO DO IT AGAIN (Y/N):");
                    String ans = input.nextLine();
                    int countCorr = 0;
                    if (ans.toLowerCase().equals("y")) {
                        int index = 1;
                        for (Question q : questions) {
                            System.out.printf("Question %d/%d \n", index++, questions.size());
                            System.out.println(q);
                            System.out.print("Your answer > ");
                            String answer = input.nextLine();
                            sm.updateAnswer(s, q, answer);
                            if (answer.toLowerCase().equals(q.getCorrect().toLowerCase())) {
                                countCorr++;
                            }
                        }
                        System.out.println("Congratulation!");
                        System.out.printf("Your result: %d/%d \n", countCorr, questions.size());
                        System.out.println("See Detail (Y/N)");
                        String see = input.nextLine();
                        if (see.toLowerCase().equals("y")) {
                            sm.printResult(questions, s);
                        } else {
                            System.exit(0);
                        }
                    } else {
                        System.out.println("Do you want see Detail (Y/N)");
                        String see = input.nextLine();
                        if (see.toLowerCase().equals("y")) {
                            sm.printResult(questions, s);
                        } else {
                            System.exit(0);
                        }
                    }

                } else {
                    System.out.println("LOGIN SUCCESS! PRESS ANY KEY TO START QUIZ");
                    input.nextLine();
                    System.out.println("---------------");

                    int countCorr = 0;
                    sm.answerQuestion(questions, sm, input, s, countCorr);
                    System.out.println("Congratulation!");
                    System.out.printf("Your result: %d/%d \n", countCorr, questions.size());
                    System.out.println("See Detail (Y/N)");
                    String see = input.nextLine();
                    if (see.toLowerCase().equals("y")) {
                        sm.printResult(questions, s);
                    }else 
                        System.exit(0);
                }

            } else {
                System.out.println("LOGIN FAIL!");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // TODO code application logic here
    }

}
