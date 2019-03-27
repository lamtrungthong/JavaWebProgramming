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
public class Camera extends Product {

    boolean hasWifi;

    public Camera() {
    }

    public Camera(boolean hasWifi, int id, String name, double price, int quantity) {
        super(id, name, price, quantity);
        this.hasWifi = hasWifi;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }


    
//Phương thức
//- override phương thức addNew() để nhập thông tin cho Camera
//Getter/Setter
//2 Contrucstor (contrustor mặc định và contrucstor đầy đủ tham số)  

    @Override
    public void addNew(Scanner sc) {
        super.addNew(sc); 
        hasWifi = false;
//To change body of generated methods, choose Tools | Templates.
    }
}
