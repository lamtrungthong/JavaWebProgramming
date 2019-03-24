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
public class TestFlashLamp {
    
    public static void main(String[] args) {
        Battery battery = new Battery();
        FlashLamp flashLamp = new FlashLamp();
//        - Bật và tắt đèn pin 10 lần
//- Hiển thị ra màn hình mức năng lượng còn lại trong pin 
        flashLamp.setBattery(battery);
        
        for (int i = 0; i < 10; i++) {
            flashLamp.turnOn();
            flashLamp.turnOff();
            System.out.println("Nang luong pin: "+battery.getEnergy());
        }
        
    }
}
