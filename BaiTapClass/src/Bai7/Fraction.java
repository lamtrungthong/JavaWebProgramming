/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Fraction {
    private int Numerator;
    private int Denominator;

    public Fraction() {
    }

    public Fraction(int Numerator, int Denominator) {
        this.Numerator = Numerator;
        this.Denominator = Denominator;
    }

    public int getNumerator() {
        return Numerator;
    }

    public void setNumerator(int Numerator) {
        this.Numerator = Numerator;
    }

    public int getDenominator() {
        return Denominator;
    }

    public void setDenominator(int Denominator) {
        this.Denominator = Denominator;
    }
    
    public void input(Scanner sc){
        System.out.println("Enter numerator: ");
        setNumerator(sc.nextInt());
        System.out.println("Enter denominator: ");
        setDenominator(sc.nextInt());
    }
    
    public void output(){
        System.out.println("Fraction: "+getNumerator()+"/"+getDenominator());
    }
    
    private int UCLN(int a, int b){
        if(b == 0)
            return a;
        else
            return (UCLN(b, a%b));
    }
    
    public Fraction reduce(){  
        int ucln = UCLN(Numerator, Denominator);
        setNumerator(this.Numerator/ucln);
        setDenominator(this.Denominator/ucln);
        return new Fraction(this.Numerator, this.Denominator);
    }
    
    public static void main(String[] args) {
        Fraction f = new Fraction(2, 4);
        f.reduce().output();
    }
}
