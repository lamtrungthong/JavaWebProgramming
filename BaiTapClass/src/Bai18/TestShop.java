/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai18;

import java.util.Scanner;

/**
 *
 * @author oo
 */
public class TestShop {
//    PRODUCT MANAGEMENT SYSTEM
// Add new product
// Remove product
// Iterate product list
// Search product
// Exit

    public static void main(String[] args) {
        Product p = new Product();
        Shop s = new Shop();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("--PRODUCT MANAGEMENT SYSTEM");
            System.out.println("1.Add new product");
            System.out.println("2.Remove product");
            System.out.println("3.Iterate product list");
            System.out.println("4.Search product");
            System.out.println("5.SortProduct");
            System.out.println("6.Exit");

            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    s.addProduct(sc);
                    break;
                case 2:
                    s.removeProduct(sc);
                    break;
                case 3:
                    s.iterateProductList();
                    break;
                case 4:
                    s.searchProduct(sc);
                    break;
                case 5:
                    s.SortProduct();
                    break;
                default:
                    break;
            }

            System.out.println("Ban co muon tiep tuc khong? (1/0) = (Y/N)");
            int ans = sc.nextInt();
            if (ans != 1) {
                break;
            }
        } while (true);

    }
}
