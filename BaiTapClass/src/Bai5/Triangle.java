/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Triangle {
    private int Canh_A;
    private int Canh_B;
    private int Canh_C;

    public Triangle() {
    }

    public Triangle(int Canh_A, int Canh_B, int Canh_C) {
        this.Canh_A = Canh_A;
        this.Canh_B = Canh_B;
        this.Canh_C = Canh_C;
    }

    public int getCanh_A() {
        return Canh_A;
    }

    public void setCanh_A(int Canh_A) {
        this.Canh_A = Canh_A;
    }

    public int getCanh_B() {
        return Canh_B;
    }

    public void setCanh_B(int Canh_B) {
        this.Canh_B = Canh_B;
    }

    public int getCanh_C() {
        return Canh_C;
    }

    public void setCanh_C(int Canh_C) {
        this.Canh_C = Canh_C;
    }
    
    public void nhap(Scanner sc){
        System.out.println("Nhap canh a: ");
        Canh_A = sc.nextInt();
        System.out.println("Nhap canh b: ");
        Canh_B = sc.nextInt();
        System.out.println("Nhap canh c: ");
        Canh_C = sc.nextInt();
    }
    
    public int tinhChuVi(){
        return Canh_A+Canh_B+Canh_C;
    }
    public double tinhDienTich(){
        int p = tinhChuVi()/2;
        return Math.sqrt(p*(p-Canh_A)*(p - Canh_B)*(p -Canh_C));
    }
    
    public static void main(String[] args) {
        Triangle t = new Triangle(3, 4, 5);
        System.out.println("Chu vi = "+t.tinhChuVi());
        System.out.println("Dien tich = "+t.tinhDienTich());
    }
}
