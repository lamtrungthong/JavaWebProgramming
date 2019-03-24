/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai18;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Shop {

    ArrayList<Product> ProductList = new ArrayList<>(); // lưu danh sách các sản phẩm của shop
    Product product;

    public int nhapGiaBan(Scanner sc) {
        int gia;
        do {
            gia = sc.nextInt();
        } while (gia < 0 || gia > 100);
        return gia;
    }

    public String nhap(Scanner sc) {
        String s;
        do {
            s = sc.nextLine();
        } while (s == null || s.length() == 0);
        return s;
    }

    public void addProduct(Scanner sc) {

        System.out.println("Ban muon nhap bao nhieu san pham?");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            product = new Product();
            System.out.println("Nhap ten san pham: ");
            product.Name = nhap(sc);
            System.out.println("Mo ta san pham: ");
            product.Description = nhap(sc);
            System.out.println("Nhap gia ban");
            product.Price = nhapGiaBan(sc);
            System.out.println("Danh gia san pham (tu 1 - 5 sao): ");
            System.out.println("San pham co bao nhieu luot danh gia?");
            int danhgia = sc.nextInt();
            for (int j = 0; j < danhgia; j++) {
                product.rate[j] = sc.nextInt();
                if (product.rate[j] < 1 || product.rate[j] > 5) {
                    System.out.println("Phai nhap tu 1 - 5. Nhap sai mac dinh la 1.");
                    product.rate[j] = 1;
                    break;
                }
            }
            ProductList.add(product);
        }
    }// yêu cầu người dùng nhập thông tin của sản phẩm rồi lưu vào ProductList

    public void removeProduct(Scanner sc) {
        System.out.println("Nhap ten san pham: ");
        String ten = new String();
        ten = nhap(sc);
        for (int i = 0; i < ProductList.size(); i++) {
            if (ten.equals(ProductList.get(i).getName())) {
                ProductList.remove(ProductList.get(i));
            } else {
                System.out.println("Khong tim thay ten san pham");
                break;
            }
        }
    }// yêu cầu người dùng nhập vào tên sản phẩm sau đó tìm và
//xóa sản phẩm có tên tương ứng trong ProductList

    void iterateProductList() {
        //Tinh trung binh cong Rate

        for (Product ProductList1 : ProductList) {
            double agvrate = 0;
            for (int i = 0; i < ProductList1.rate.length; i++) {
                agvrate += ProductList1.rate[i];
            }
            agvrate /= ProductList1.rate.length;
            ProductList1.viewInfo();
            System.out.println("Average Rate of product: " + agvrate);
        }
    } // hiển thị các sản phẩm trong ProductList, gọi phương
//thức viewInfo() của lớp Product, tính trung bình cộng đánh giá cho từng sản phẩm
//và hiển thị thông tin ra màn hình.

    void searchProduct(Scanner sc) {
        System.out.println("Nhap vao 2 so!");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        for (Product ProductList1 : ProductList) {
            if (x < y) {
                if (ProductList1.Price >= x && ProductList1.Price <= y) {
                    ProductList1.viewInfo();
                }
            } else {
                if (ProductList1.Price >= y && ProductList1.Price <= x) {
                    ProductList1.viewInfo();
                }
            }
        }
    }// yêu cầu người dùng nhập vào 2 số, sau đó tìm và hiển thị
//thông tin của những sản phẩm có giá nằm giữa hai số đó. 

    public void SortProduct() {
        double temp = 0;
        //Tang dan
        for (int i = 0; i < ProductList.size() - 1; i++) {
            for (int j = i + 1; j < ProductList.size(); j++) {
                if (ProductList.get(i).Price > ProductList.get(j).Price) {
                    temp = ProductList.get(i).Price;
                    ProductList.get(i).Price = ProductList.get(j).Price;
                    ProductList.get(j).Price = temp;
                }
            }
        }
    }
//    int[] a = {1, 5, 2, 4, 3};
//
//    public void tangdan() {
//
//        int n = 5;
//        int temp = 0;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (a[i] > a[j]) {
//                    temp = a[i];
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//       Shop s =  new Shop();
//       s.tangdan();
//        for (int i = 0; i < 5; i++) {
//            System.out.println(s.a[i]);
//        }
//    }
//    Tạo thêm một mục trong Menu ứng với phương thức gọi là SortProduct() 
    //  đặt trong
//lớp Shop để sắp xếp các sản phẩm trong ProductList theo giá.
}
