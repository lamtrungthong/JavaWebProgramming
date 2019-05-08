/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class StudentManager {

    Student st = new Student();

    public void add(Scanner sc, ArrayList<Student> arr) {

        System.out.print("RollNumber= ");
        st.setRollnumber(sc.nextLine());
        System.out.print("Name= ");
        st.setName(sc.nextLine());
        st.dob = new Date();
        System.out.print("Year= ");
        int y = Integer.parseInt(sc.nextLine());
        System.out.print("Month= ");
        int m = Integer.parseInt(sc.nextLine());
        System.out.print("Day= ");
        int d = Integer.parseInt(sc.nextLine());
        SimpleDateFormat ft = new SimpleDateFormat(y + "/" + m + "/" + d);
        System.out.print("Email= ");
        st.setEmail(sc.nextLine());

    }

    public Student search(ArrayList<Student> arr, String name) {
        for (Student student : arr) {

            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public void update(ArrayList<Student> arr, String name, int index) {
        for (int i = 0; i < arr.size(); i++) {
            if (i == index) {
                arr.get(i).setName(name);
            }

        }
    }

    public void delete(ArrayList<Student> arr, String name) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getName().equals(name)) {
                arr.remove(i);
            }
        }
    }

    public void save(ArrayList<Student> arr) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("student.dat")));
            oos.writeObject(arr);
            oos.flush();
            oos.close();
        } catch (Exception e) {
        }
    }

    public void upload(ArrayList<Student> arr) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("student.dat")));
            arr = (ArrayList<Student>) ois.readObject();
            ois.close();
        } catch (Exception e) {
        }
    }

    public void show(ArrayList<Student> arr) {
        for (Student student : arr) {
            student.toString();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.print("Dob= ");
        student.dob = new Date();
        System.out.print("Year= ");
        int y = sc.nextInt();
        System.out.print("Month= ");
        int m = sc.nextInt();
        System.out.print("Day= ");
        int d = sc.nextInt();
        SimpleDateFormat ft = new SimpleDateFormat(y + "." + m + "." + d);
        System.out.println("" + ft.format(student.dob));
    }
}
