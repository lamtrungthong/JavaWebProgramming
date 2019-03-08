/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai9;

/**
 *
 * @author oo
 */
public class Vecto {

    private int HoanhDoDau;
    private int TungDoDau;
    private int HoanhDoCuoi;
    private int TungDoCuoi;

    public Vecto() {
    }

    public Vecto(int HoanhDoDau, int TungDoDau, int HoanhDoCuoi, int TungDoCuoi) {
        this.HoanhDoDau = HoanhDoDau;
        this.TungDoDau = TungDoDau;
        this.HoanhDoCuoi = HoanhDoCuoi;
        this.TungDoCuoi = TungDoCuoi;
    }

    public int getHoanhDoDau() {
        return HoanhDoDau;
    }

    public void setHoanhDoDau(int HoanhDoDau) {
        this.HoanhDoDau = HoanhDoDau;
    }

    public int getTungDoDau() {
        return TungDoDau;
    }

    public void setTungDoDau(int TungDoDau) {
        this.TungDoDau = TungDoDau;
    }

    public int getHoanhDoCuoi() {
        return HoanhDoCuoi;
    }

    public void setHoanhDoCuoi(int HoanhDoCuoi) {
        this.HoanhDoCuoi = HoanhDoCuoi;
    }

    public int getTungDoCuoi() {
        return TungDoCuoi;
    }

    public void setTungDoCuoi(int TungDoCuoi) {
        this.TungDoCuoi = TungDoCuoi;
    }

    public boolean isVectoBangNhau(Vecto x) {
        if ((this.HoanhDoCuoi - this.HoanhDoDau)
                == (x.HoanhDoCuoi - x.HoanhDoDau)) {
            if ((this.TungDoCuoi - this.TungDoDau)
                    == (x.TungDoCuoi - x.TungDoDau)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    
}
