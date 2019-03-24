/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai11;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Matran {

    private int SoHang;
    private int SoCot;
    private int[][] MT;

    public Matran() {
    }

    public Matran(int SoHang, int SoCot) {
        this.SoHang = SoHang;
        this.SoCot = SoCot;
    }

    public int getSoHang() {
        return SoHang;
    }

    public void setSoHang(int SoHang) {
        this.SoHang = SoHang;
    }

    public int getSoCot() {
        return SoCot;
    }

    public void setSoCot(int SoCot) {
        this.SoCot = SoCot;
    }

    public void nhapMaTran(Scanner sc) {
        System.out.println("Nhap so hang: ");
        this.SoHang = sc.nextInt();
        System.out.println("Nhap so cot: ");
        this.SoCot = sc.nextInt();
        MT = new int[SoHang][SoCot];
        for (int i = 0; i < SoHang; i++) {
            for (int j = 0; j < SoCot; j++) {
                System.out.println("Nhap [" + i + "][" + j + "] = ");
                this.MT[i][j] = sc.nextInt();
            }

        }
    }

    public void xuatMaTran(Matran a) {
        System.out.println("Ma tran: ");
        for (int i = 0; i < a.SoHang; i++) {
            for (int j = 0; j < a.SoCot; j++) {
                System.out.print(a.MT[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void congMaTran(Matran x) {
        for (int i = 0; i < SoHang; i++) {
            for (int j = 0; j < SoCot; j++) {
                this.MT[i][j] += x.MT[i][j];
            }
        }
    }
//Đang bị lỗi chưa giải quyết được
    public void nhanMaTran(Matran b, Matran c) {
        c.MT = new int[SoHang][b.SoCot];
        //System.out.println("So cot ma tran 1 can bang so hang ma tran 2!");     
            for (int i = 0; i < this.SoHang; i++) {
                for (int j = 0; j < b.SoCot; j++) {
                    c.MT[i][j] = 0;
                    for (int k = 0; k < this.SoCot; k++) {
                        c.MT[i][j] += this.MT[i][k] * b.MT[k][j];
                    }
                }
            }
        }
    

    public static void main(String[] args) {
        Matran mt = new Matran();
        Matran mt2 = new Matran();
        Matran mt3 = new Matran();
        Scanner sc = new Scanner(System.in);
        mt.nhapMaTran(sc);
        mt2.nhapMaTran(sc);
        mt.congMaTran(mt2);
//        mt.nhanMaTran(mt2, mt3);
//        mt.xuatMaTran(mt3);
//Chưa hoàn thành nhân ma trận
        mt.xuatMaTran(mt);
    }
}
