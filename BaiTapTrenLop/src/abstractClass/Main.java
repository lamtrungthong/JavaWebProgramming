/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractClass;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Main {

    public static void main(String[] args) {
        Manager m;
        Student st;
        Employee em;
        Menu menu = new Menu();

        Scanner sc = new Scanner(System.in);
        System.out.println("Who am i? (1/0)");
        int ans = sc.nextInt();
        int anss;
        if (ans == 0) {
            m = new StudentManager();
            st = new Student();
            menu.display(sc, m);

        } else {
            m = new EmployeeManager();
            em = new Employee();
            menu.display(sc, m);
        }

    }
}
