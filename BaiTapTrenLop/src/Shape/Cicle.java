/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shape;

/**
 *
 * @author oo
 */
public class Cicle {
    private double Radius;

    public Cicle() {
    }

    public Cicle(double Radius) {
        this.Radius = Radius;
    }

    public double getRadius() {
        return Radius;
    }

    public void setRadius(double Radius) {
        this.Radius = Radius;
    }
    
    public double area(){
        return Math.PI*Radius*Radius;
    }
}
