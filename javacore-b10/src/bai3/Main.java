/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Main {

    public static void main(String[] args) {
        Task t = new Task();
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);
        int menu;
        do {
            System.out.println("-- --TODO App----");
            System.out.println("1. Load tasks");
            System.out.println("2. Show tasks");
            System.out.println("3. Create new task");
            System.out.println("4. Filter by Status");
            System.out.println("5. Update Status");
            System.out.println("6. View Detail");
            System.out.println("7. Exit Choose ?");

             menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Enter file path: <Ng dùng nhập đường dẫn>");
                    System.out.println("Load data Successful");
break;
                case 2:
                    tm.showAll();
                    break;
                case 3:
                    tm.add(t);
                    break;
                case 4:
                    tm.showDone(true);
                    break;
                case 5:
                    tm.updateStatus(1, false);
                    break;
                case 6:
                    tm.showAll();
                    break;
                case 7:
                    System.exit(0);

            }

        } while (menu != 7);
    }
}
