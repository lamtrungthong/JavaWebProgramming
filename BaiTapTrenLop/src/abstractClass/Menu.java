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
public class Menu {

    public void display(Scanner sc, Manager m) {
        int ans;
        do {            
            System.out.println("======MENU=====");
        System.out.println("1. Add");
        System.out.println("2. Show");
        System.out.println("3. Search");
        System.out.println("4. Exit");
        System.out.println("Choose");
         ans = sc.nextInt();
        switch (ans) {
            case 1:
                m.add();
                break;
            case 2:
                m.show();
                break;
            
            case 3:
                m.search();
                break;
            default:
                break;
        }
        } while (ans != 4);
    }
}
