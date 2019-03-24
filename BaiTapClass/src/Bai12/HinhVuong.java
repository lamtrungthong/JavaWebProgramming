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
public class HinhVuong extends HinhChuNhat{

    int DoDaiCanh;
    public HinhVuong() {
    }

    public HinhVuong(int DoDaiCanh) {
        this.DoDaiCanh = DoDaiCanh;
    }

    public int getDoDaiCanh() {
        return DoDaiCanh;
    }

    public void setDoDaiCanh(int DoDaiCanh) {
        this.DoDaiCanh = DoDaiCanh;
    }

    @Override
    public double tinhDienTich() {
        return DoDaiCanh*DoDaiCanh;
    }

    @Override
    public double tinhChuVi() {
        return DoDaiCanh*2;
    }

    @Override
    public void nhapTT(Scanner sc) {
        System.out.println("Nhap do dai canh: ");
        DoDaiCanh = sc.nextInt();
    }
    
    public static void main(String[] args) {
        HinhVuong hv =new HinhVuong(4);
        System.out.println(""+hv.tinhDienTich());
    }
    
    
}
