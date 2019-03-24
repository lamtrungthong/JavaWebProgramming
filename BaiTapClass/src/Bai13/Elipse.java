/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai13;

import java.awt.Point;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Elipse extends Diem{

    
    public Elipse() {
    }

    public Elipse(Point diem) {
        super(diem);
    }
    public void nhapDiem(Scanner sc){
        int x, y;
        System.out.println("Nhap a: ");
        x = sc.nextInt();
        System.out.println("Nhap b: ");
        y = sc.nextInt();
        diem = new Point(x, y);
    }
    public double tinhDienTich(){
        return Math.PI*diem.x*diem.y;
    }
    
    public static void main(String[] args) {
        Elipse el = new Elipse();
        Scanner sc = new Scanner(System.in);
        el.nhapDiem(sc);
        System.out.println(""+el.tinhDienTich());
        
    }
}
