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
public class HinhBinhHanh extends DaGiac{

    int ChieuCao;
    int Day;
    int ChieuRong;
    public HinhBinhHanh() {
    }

    public HinhBinhHanh(int ChieuCao, int Day, int ChieuRong) {
        this.ChieuCao = ChieuCao;
        this.Day = Day;
        this.ChieuRong = ChieuRong;
    }

    public int getChieuRong() {
        return ChieuRong;
    }

    public void setChieuRong(int ChieuRong) {
        this.ChieuRong = ChieuRong;
    }

    public int getChieuCao() {
        return ChieuCao;
    }

    public void setChieuCao(int ChieuCao) {
        this.ChieuCao = ChieuCao;
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int Day) {
        this.Day = Day;
    }

    @Override
    public double tinhDienTich() {
        return Day*ChieuCao;
    }

    @Override
    public double tinhChuVi() {
        return (Day + ChieuRong)*2;
    }

    @Override
    public void nhapTT(Scanner sc) {
        System.out.println("Nhap day: ");
        Day = sc.nextInt();
        System.out.println("Nhap chieu cao: ");
        ChieuCao = sc.nextInt();
        System.out.println("Nhap chieu rong: ");
        ChieuRong = sc.nextInt();
    }

    
    
    
}
