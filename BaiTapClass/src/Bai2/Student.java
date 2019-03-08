/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Student {

    private String MSSV;
    private float DiemTB;
    private int Tuoi;
    private String Lop;

    public Student() {
    }

    public Student(String MSSV, float DiemTB, int Tuoi, String Lop) {
        this.MSSV = MSSV;
        this.DiemTB = DiemTB;
        this.Tuoi = Tuoi;
        this.Lop = Lop;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public float getDiemTB() {
        return DiemTB;
    }

    public void setDiemTB(float DiemTB) {
        this.DiemTB = DiemTB;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    //MSSV chua 8 ky tu
    public String nhapMSSV(Scanner sc) {
        String ms;
        do {
            ms = sc.nextLine();
        } while (ms.length() != 8);
        return ms;
    }

    //Diem TB 0-10
    public float nhapDiemTB(Scanner sc) {
        float diem;
        do {
            diem = sc.nextFloat();
        } while (diem < 0 || diem > 10);
        return diem;
    }

    //Tuoi >= 18
    public int nhapTuoi(Scanner sc) {
        int tuoi;
        do {
            tuoi = sc.nextInt();
        } while (tuoi < 18);
        return tuoi;
    }

    //Lop bat dau bang "A" or "C"
    public String nhapLop(Scanner sc) {
        String lop;
        String[] lops;
        do {
            lop = sc.nextLine();
            lops = lop.split("");
            if (lops[0].equals("A") || lops[0].equals("C")) {
                break;
            }
        } while (true);
        return lop;
    }
//nhap
    public void inputInfo(Scanner sc) {
        System.out.println("Nhap MSSV: ");
        nhapMSSV(sc);
        System.out.println("Nhap diem TB: ");
        nhapDiemTB(sc);
        System.out.println("Nhap tuoi: ");
        nhapTuoi(sc);
        System.out.println("Nhap lop: ");
        nhapLop(sc);
    }
//in
    public void showInfo(){
        System.out.println("MSSV: "+MSSV);
        System.out.println("Diem TB: "+DiemTB);
        System.out.println("Tuoi: "+Tuoi);
        System.out.println("Lop: "+Lop);
    }
    //set hoc bong
    public void setHocBong(){
        if(DiemTB > 8){
            System.out.println("Hoc bong!");
        }else
            System.out.println("Khong!");
    }
    
    public static void main(String[] args) {
       // Scanner sc = new Scanner(System.in);
        //new Student().inputInfo(sc);
        Student st = new Student("abc12345", 9, 19, "CNTT");
        st.setHocBong();
    }
}
