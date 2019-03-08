/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai6;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Rectangle {
    private int ChieuDai;
    private int ChieuRong;

    public Rectangle() {
    }

    public Rectangle(int ChieuDai, int ChieuRong) {
        this.ChieuDai = ChieuDai;
        this.ChieuRong = ChieuRong;
    }

    public int getChieuDai() {
        return ChieuDai;
    }

    public void setChieuDai(int ChieuDai) {
        this.ChieuDai = ChieuDai;
    }

    public int getChieuRong() {
        return ChieuRong;
    }

    public void setChieuRong(int ChieuRong) {
        this.ChieuRong = ChieuRong;
    }
    
    public void nhap(Scanner sc){
        System.out.println("Nhap chieu dai: ");
        ChieuDai = sc.nextInt();
        System.out.println("Nhap chieu rong: ");
        ChieuRong = sc.nextInt();
    }
    
    public int tinhDienTich(){
        return ChieuDai*ChieuRong;
    }
    public int tinhChiVi(){
        return (ChieuDai+ChieuRong)*2;
    }
    
    public static void main(String[] args) {
        Rectangle r = new Rectangle(4, 2);
        System.out.println("Dien tich = "+r.tinhDienTich());
        System.out.println("Chu vi = "+r.tinhChiVi());
    }
}
