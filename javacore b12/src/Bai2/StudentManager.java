/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class StudentManager {
    Student st = new Student();
    
    public void add(Scanner sc){
    
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
        SimpleDateFormat ft = new SimpleDateFormat(y+"/"+m+"/"+d);
        System.out.print("Email= ");
        st.setEmail(sc.nextLine());
        
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
        SimpleDateFormat ft = new SimpleDateFormat(y+"."+m+"."+d);
        System.out.println(""+ft.format(student.dob));
    }
}
