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
public class Store {

    Product[] products;
    int numbers;

    public Store() {

    }

    public Store(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void addProduct(Scanner sc) {

        Product p;
        System.out.println("--Them san pham");
        System.out.println("1. SmartPhone.");
        System.out.println("2. Camera.");
        int choice = sc.nextInt();
        if (choice == 1) {
            p = new Camera();
        } else {
            p = new Smartphone();
        }
        p.addNew(sc);
        //Co them dc hay khong;
        if (numbers >= products.length) {
            System.out.println("Khong them duoc");
            return;
        }
        products[numbers] = p;
        numbers++;
    }

    void listProduct() {
        System.out.println("=====Danh Sach=====");
        for (Product p : products) {
            if (p == null) {
                break;
            }
            System.out.println(p);
        }
    }

    void search(String name) {
        for (Product p : products) {
            if (p == null) {
                break;
            }
            if (p.getName().equals(name)) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Khong tim thay");
    }
//    Tạo class Store có
//Thuộc tính
//- Product[] products; //mảng chứa sản phẩm
//Phương thức
//- void addProduct(); // nhập sản phẩm, dùng Scanner, người dùng có thể chọn
//nhập sản phẩm SmartPhone hoặc Camera
//- void listProduct(); // in ra danh sách sản phẩm dưới dạng bảng
//- void search(String name); tìm kiếm thông tin sản phẩm theo tên
}
