/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Menu {

    static Map<String, String> myMap;

    public static void translates(String file) {
        try {
            FileReader fr = new FileReader(new File(file));
            BufferedReader br = new BufferedReader(fr);
            String s;
            String[] maps;
            myMap = new HashMap<>();
            while ((s = br.readLine()) != null) {
                maps = s.split("=");
                myMap.put(maps[0], maps[1]);
            }

            br.close();
            fr.close();
        } catch (Exception e) {
        }
    }

    public static void showMenu() {
        System.out.println("==========" + myMap.get("Menu") + "==========");
        System.out.println("1." + myMap.get("Add new"));
        System.out.println("2." + myMap.get("Search by name"));
        System.out.println("3." + myMap.get("Update"));
        System.out.println("4." + myMap.get("Delete"));
        System.out.println("5." + myMap.get("Save"));
        System.out.println("6." + myMap.get("Language"));
        System.out.println("7." + myMap.get("Exit"));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        translates("MenuEn.dat");
        showMenu();

        int menu = sc.nextInt();

        switch (menu) {
            case 6:
                System.out.println("==========Menu==========");
                System.out.println("1.English");
                System.out.println("2.VietNamese");
                int language = sc.nextInt();
                switch (language) {
                    case 1:
                        translates("MenuEn.dat");
                        showMenu();
                        break;
                    case 2:
                        translates("MenuVi2.dat");
                        showMenu();
                        break;
                }
                break;
        }

    }
}
