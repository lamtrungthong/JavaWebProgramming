/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractClass;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Employee extends Person{
    private double Salary;

    public Employee() {
    }

    public Employee(double Salary, String ID, String Name) {
        super(ID, Name);
        this.Salary = Salary;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Nhap luong: ");
        Salary = sc.nextDouble();
    }

    @Override
    public void output() {
        super.output(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Luong: "+Salary);
    }
    
    
}
