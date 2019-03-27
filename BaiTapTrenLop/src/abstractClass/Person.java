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
public class Person {
    private String ID ;
    private String Name ;

    public Person() {
    }

    public Person(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    public String nhap(Scanner sc){
        String s;
        do {            
            s = sc.nextLine();
        } while (s == null || s.length() == 0);
        return s;
    }
    public void input(Scanner sc){
        System.out.println("Nhap ID: ");
        ID = nhap(sc);
        System.out.println("Nhap ten: ");
        Name = nhap(sc);
    }
    public void output(){
        System.out.println("ID: "+ID);
        System.out.println("Ten: "+Name);
    }
}
