/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import com.sun.corba.se.impl.util.Utility;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class NhanVien {

    private String Ten;
    private String Tuoi;
    private String DiaChi;
    private double TienLuong;
    private int SoGioLam;

    public NhanVien() {
    }

    public NhanVien(String Ten, String Tuoi, String DiaChi, double TenLuong, int SoGioLam) {
        this.Ten = Ten;
        this.Tuoi = Tuoi;
        this.DiaChi = DiaChi;
        this.TienLuong = TenLuong;
        this.SoGioLam = SoGioLam;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getTuoi() {
        return Tuoi;
    }

    public void setTuoi(String Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public double getTienLuong() {
        return TienLuong;
    }

    public void setTienLuong(double TienLuong) {
        this.TienLuong = TienLuong;
    }

    public int getSoGioLam() {
        return SoGioLam;
    }

    public void setSoGioLam(int SoGioLam) {
        this.SoGioLam = SoGioLam;
    }

    public void inputInfo(Scanner sc) {
        System.out.println("Nhap ten: ");
        Ten = sc.nextLine();
        System.out.println("Nhap tuoi: ");
        Tuoi = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        DiaChi = sc.nextLine();
        System.out.println("Nhap tien luong: ");
        TienLuong = sc.nextDouble();
        System.out.println("Nhap so gio lam: ");
        SoGioLam = sc.nextInt();
    }

    public void printInfo() {
        System.out.println("Ten: " + Ten);
        System.out.println("Tuoi: " + Tuoi);
        System.out.println("Dia chi: " + DiaChi);
        System.out.println("Tien luong: " + TienLuong);
        System.out.println("Tong so gio lam: " + SoGioLam);
    }

    public double tinhThuong() {
        if (SoGioLam >= 200) {
            return (TienLuong * 20) / 100;
        } else if (SoGioLam < 200 && SoGioLam >= 100) {
            return (TienLuong * 10) / 100;
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        NhanVien nv= new NhanVien("a", "a", "a", 100, 200);
        System.out.println("Tien thuong: "+nv.tinhThuong());
    }
}
