/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai18;

/**
 *
 * @author oo
 */
public class Product {

    String Name;// Ten
    String Description; // Mieu ta
    double Price; // 0 < Gia <= 100
    int[] rate; // lưu các đánh giá của người dùng cho sản phẩm, giá trị từ 1 - 5

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int[] getRate() {
        return rate;
    }

    public void setRate(int[] rate) {
        this.rate = rate;
    }

    public Product(String Name, String Description, double Price, int[] rate) {
        this.Name = Name;
        this.Description = Description;
        this.Price = Price;
        this.rate = rate;
    }

    public Product() {
    }

    public void viewInfo() {
        System.out.println("Name of product: "+Name);
        System.out.println("Description of product: "+Description);
        System.out.println("Price of product: "+Price);
    } // hiển thị tên, giá và mô tả về sản phẩm 
}
