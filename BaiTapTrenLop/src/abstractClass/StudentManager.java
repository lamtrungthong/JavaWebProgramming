/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractClass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class StudentManager extends Manager {

    Student student;
    ArrayList<Student> arr = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {

        System.out.println("Nhap bao nhieu hoc sinh?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            student = new Student();
            System.out.println("Nhap hoc sinh thu: " + (i + 1));
            student.input(sc);
            arr.add(student);
        }

    }

    @Override
    public void show() {
        for (Student arr1 : arr) {
            arr1.output();
        }
    }

    @Override
    public void search() {
        System.out.println("Ten can tim kiem? ");
        String name = student.nhap(sc);
        for (Student arr1 : arr) {
            if (arr1.getName().equals(name)) {
                arr1.output();
            }
        }
    }

}
