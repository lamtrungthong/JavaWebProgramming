/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai17;

/**
 *
 * @author oo
 */
public class MyCircle {
    private MyPoint Tam ;
    private int BanKinh;

    public MyCircle() {
        this.Tam = new MyPoint(0, 0);
        this.BanKinh = 1;
    }

    public MyCircle(MyPoint Tam, int BanKinh) {
        this.Tam = Tam;
        this.BanKinh = BanKinh;
    }

    public MyPoint getTam() {
        return Tam;
    }

    public void setTam(MyPoint Tam) {
        this.Tam = Tam;
    }

    public int getBanKinh() {
        return BanKinh;
    }

    public void setBanKinh(int BanKinh) {
        this.BanKinh = BanKinh;
    }

    @Override
    public String toString() {
        return "Hình tròn @ "+"("+this.Tam.getX()+","+this.Tam.getY()+") bán kính= "+this.BanKinh;
    }
    
    public double getArea(){
        return Math.PI*BanKinh*BanKinh;
    } 
    
    
}
