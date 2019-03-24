/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai12;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class HinhChuNhat extends HinhBinhHanh{

    
    
    public HinhChuNhat() {
    }

    @Override
    public double tinhDienTich() {
        return super.tinhDienTich(); 
    }

    @Override
    public double tinhChuVi() {
        return super.tinhChuVi(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nhapTT(Scanner sc) {
        super.nhapTT(sc); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat(2, 4);
        System.out.println(""+hcn.tinhDienTich());
    }
}
