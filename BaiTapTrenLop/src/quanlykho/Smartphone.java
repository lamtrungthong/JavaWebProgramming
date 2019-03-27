/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykho;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Smartphone extends  Product{
    boolean hasCamera;
    int sim;
public Smartphone() {
    }
    public Smartphone(boolean hasCamera, int sim, int id, String name, double price, int quantity) {
        super(id, name, price, quantity);
        this.hasCamera = hasCamera;
        this.sim = sim;
    }

    public boolean isHasCamera() {
        return hasCamera;
    }

    public void setHasCamera(boolean hasCamera) {
        this.hasCamera = hasCamera;
    }

    public int getSim() {
        return sim;
    }

    public void setSim(int sim) {
        this.sim = sim;
    }
    
//Phương thức
//- override phương thức addNew() để nhập thông tin cho SmartPhone
//Getter/Setter
//2 Contrucstor (contrustor mặc định và contrucstor đầy đủ tham số)

    @Override
    public void addNew(Scanner sc) {
        super.addNew(sc);
        hasCamera = false;
        System.out.println("Nhap sim: ");
        sim = sc.nextInt();
        
//To change body of generated methods, choose Tools | Templates.
    }

    
}
