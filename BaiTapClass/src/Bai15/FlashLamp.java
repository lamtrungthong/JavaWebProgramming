/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai15;

/**
 *
 * @author oo
 */
public class FlashLamp {
    private boolean Status;
    private Battery battery;

    public FlashLamp() {
        this.Status = false;
        this.battery = null;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getBatteryInfo() {
        return battery.getEnergy();
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }
     public void turnOn(){
         this.Status = true;
         if(this.Status == true && this.battery.getEnergy() > 0){ 
             System.out.println("Den sang!");
             this.battery.decreaseEnergy();
         }
      }
     public void turnOff(){
         this.Status = false;
         if(this.Status == false || this.battery.getEnergy() <= 0){ 
             System.out.println("Den khong sang!");
         }
     }
}
