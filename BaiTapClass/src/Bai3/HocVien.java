/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

/**
 *
 * @author oo
 */
public class HocVien {

    private String KhoaHoc;
    private float DiemTK;
    private boolean NoiQuy;
    private int LanThi;

    public HocVien() {
    }

    public HocVien(String KhoaHoc, float DiemTK, boolean NoiQuy, int LanThi) {
        this.KhoaHoc = KhoaHoc;
        this.DiemTK = DiemTK;
        this.NoiQuy = NoiQuy;
        this.LanThi = LanThi;
    }

    public String getKhoaHoc() {
        return KhoaHoc;
    }

    public void setKhoaHoc(String KhoaHoc) {
        this.KhoaHoc = KhoaHoc;
    }

    public float getDiemTK() {
        return DiemTK;
    }

    public void setDiemTK(float DiemTK) {
        this.DiemTK = DiemTK;
    }

    public boolean isNoiQuy() {
        return NoiQuy;
    }

    public void setNoiQuy(boolean NoiQuy) {
        this.NoiQuy = NoiQuy;
    }

    public int getLanThi() {
        return LanThi;
    }

    public void setLanThi(int LanThi) {
        this.LanThi = LanThi;
    }

    public void setHocBong() {
        if (KhoaHoc.equals("HDSE")) {
            if (DiemTK >= 7.5) {
                if (NoiQuy == false) {
                    if (LanThi == 1) {
                        System.out.println("Hoc bong!");
                    } else {
                        System.out.println("Khong!");
                    }
                } else {
                    System.out.println("Khong!");
                }
            } else {
                System.out.println("Khong!");
            }
        } else {
            System.out.println("Khong!");
        }
    }
    
    public static void main(String[] args) {
        HocVien hv = new HocVien("HDSE", 8, false, 1);
         HocVien hv2 = new HocVien("HDSE", 8, false, 2);
         hv.setHocBong();
         hv2.setHocBong();
    }
}
