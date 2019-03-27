/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractClass;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class EmployeeManager extends Manager {

    Employee employee;
    ArrayList<Employee> arr = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {

        System.out.println("Nhap bao nhieu nhan vien?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            employee = new Employee();
            System.out.println("Nhap hoc sinh thu: " + (i + 1));
            employee.input(sc);
            arr.add(employee);
        }

    }

    @Override
    public void show() {
        for (Employee arr1 : arr) {
            arr1.output();
        }
    }

    @Override
    public void search() {
        System.out.println("Ten can tim kiem? ");
        String name = employee.nhap(sc);
        for (Employee arr1 : arr) {
            if (name.equals(arr1.getName())) {
                arr1.output();
            }
        }
    }

}
