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
public class Product {

    int id;
    String name;
    double price;
    int quantity;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//Phương thức
//- void addNew(); //Dùng Scanner để nhập vào sản phẩm
//Getter/Setter
//2 Contrucstor (contrustor mặc định và contrucstor đầy đủ tham số)
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String nhap(Scanner sc) {
        String s;
        do {
            s = sc.nextLine();
        } while (s == null || s.length() == 0);
        return s;
    }

    public void addNew(Scanner sc) {
        System.out.println("Nhap ID: ");
        id = sc.nextInt();
        System.out.println("Nhap Ten: ");
        name = nhap(sc);
        System.out.println("Nhap gia ban: ");
        price = sc.nextDouble();
        System.out.println("Nhap so luong: ");
        quantity = sc.nextInt();
    }
}
