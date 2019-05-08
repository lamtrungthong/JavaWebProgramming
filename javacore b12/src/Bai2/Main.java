/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.ArrayList;

/**
 *
 * @author oo
 */
public class Main {

    public static void main(String[] args) {
        StudentManager stm = new StudentManager();
        Menu menu = new Menu();
        ArrayList<Student> arr= new ArrayList<>();
        
        menu.print(stm, arr);
    }
}
