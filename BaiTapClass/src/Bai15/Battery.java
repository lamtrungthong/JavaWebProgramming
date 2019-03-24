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
public class Battery {
    private int Energy;

    public Battery() {
        this.Energy = 10;
    }

    

    
    public int getEnergy() {
        return Energy;
    }

    public void setEnergy(int Energy) {
        this.Energy = Energy;
    }
    public void decreaseEnergy(){
        Energy -=2;
    }
}
