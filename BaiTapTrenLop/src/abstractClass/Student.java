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
public class Student extends Person{
    private String Email ;

    public Student() {
    }

    public Student(String Email, String ID, String Name) {
        super(ID, Name);
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Nhap Email: ");
        Email = nhap(sc);
    }

    @Override
    public void output() {
        super.output(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Emai: "+Email);
    }
    
}
