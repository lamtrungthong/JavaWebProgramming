/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai8;

/**
 *
 * @author oo
 */
public class SoPhuc {

    private int PhanThuc;
    private int PhanAo;

    public SoPhuc() {
    }

    public SoPhuc(int PhanThuc, int PhanAo) {
        this.PhanThuc = PhanThuc;
        this.PhanAo = PhanAo;
    }

    public int getPhanThuc() {
        return PhanThuc;
    }

    public void setPhanThuc(int PhanThuc) {
        this.PhanThuc = PhanThuc;
    }

    public int getPhanAo() {
        return PhanAo;
    }

    public void setPhanAo(int PhanAo) {
        this.PhanAo = PhanAo;
    }

    public SoPhuc cong(SoPhuc a) {
        SoPhuc z = new SoPhuc();
        z.PhanThuc = this.PhanThuc + a.PhanThuc;
        z.PhanAo = this.PhanAo + a.PhanAo;
        return z;
    }

    public SoPhuc tru(SoPhuc a) {
        SoPhuc z = new SoPhuc();
        z.PhanThuc = this.PhanThuc - a.PhanThuc;
        z.PhanAo = this.PhanAo - a.PhanAo;
        return z;
    }

    public SoPhuc nhan(SoPhuc a) {
        SoPhuc z = new SoPhuc();
        z.PhanThuc = (this.PhanThuc * a.PhanThuc) - (this.PhanAo * a.PhanAo);
        z.PhanAo = (this.PhanThuc * a.PhanAo) + (a.PhanThuc * this.PhanAo);
        return z;
    }

    public SoPhuc chia(SoPhuc a) {
        SoPhuc z = new SoPhuc();
        z.PhanThuc = ((this.PhanThuc * a.PhanThuc) + (this.PhanAo * a.PhanAo))
                /(this.PhanThuc*this.PhanThuc + this.PhanAo*this.PhanAo);
        z.PhanAo = ((this.PhanThuc * a.PhanAo) - (a.PhanThuc * this.PhanAo)) 
                /(this.PhanThuc*this.PhanThuc + this.PhanAo*this.PhanAo);
        return z;
    }

    public static void main(String[] args) {
        SoPhuc z1 = new SoPhuc(1, 2);
        SoPhuc z2 = new SoPhuc(1, 2);

        System.out.println("z = z1 + z1 = " + z1.cong(z2).PhanThuc + " + " + z1.cong(z2).PhanAo + "i");
        System.out.println("z = z1 - z1 = " + z1.tru(z2).PhanThuc + " + " + z1.tru(z2).PhanAo + "i");
        System.out.println("z = z1 * z1 = " + z1.nhan(z2).PhanThuc + " + " + z1.nhan(z2).PhanAo + "i");
        System.out.println("z = z1 / z1 = " + z1.chia(z2).PhanThuc + " + " + z1.chia(z2).PhanAo + "i");
    }
}
