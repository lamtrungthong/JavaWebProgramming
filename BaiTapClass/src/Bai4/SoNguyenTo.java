/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

/**
 *
 * @author oo
 */
public class SoNguyenTo {
    
    private int a;
    
    public SoNguyenTo() {
    }
    
    public SoNguyenTo(int x) {
        if (isSoNguyenTo(x) == true) {
            this.a = x;
        } else {
            System.out.println(x + " khong phai la so nguyen to, khong luu tru.");
        }
    }
    
    public int getA() {
        return a;
    }
    
    public void setA(int a) {
        if(isSoNguyenTo(a))
            this.a = a;
        else 
            System.out.println("Khong set");
    }
    
    public static boolean isSoNguyenTo(int x) {
        if (x < 2) {
            return false;
        } else {
            for (int i = 2; i < x - 1; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int timSoNguyenToTiepTheo() {
        int x = this.a;
        do {
            if (isSoNguyenTo(this.a) == true) {
                x++;
            }else {
                System.out.println(this.a+" khong phai so nguyen to, khong tim thay so nguyen to tiep theo");
                break;
            }
        } while (isSoNguyenTo(x) == false);
        return x;
    }
    
    public static void main(String[] args) {
         SoNguyenTo snt = new SoNguyenTo(5);
        System.out.println("" +snt.a);
        System.out.println(""+snt.timSoNguyenToTiepTheo());
        snt.setA(4);
    }
}
