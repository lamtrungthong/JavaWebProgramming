/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class Menu {

        private Map<String, String> map;

    public Menu() {
        this.map = new HashMap<>();
        this.loadData("En");
    }

    public void loadData(String lang) {
        try {
            String fileName = "Menu" + lang + ".dat";
            BufferedReader reader
                    = new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(fileName)));
            this.map.clear();
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] split = line.split("=");
                this.map.put(split[0], split[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print(StudentManager stm, ArrayList<Student> arr) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.printf("\n------%s------", this.map.get("menu"));
            System.out.printf("\n1. %s", this.map.get("add"));
            System.out.printf("\n2. %s", this.map.get("search"));
            System.out.printf("\n3. %s", this.map.get("update"));
            System.out.printf("\n4. %s", this.map.get("delete"));
            System.out.printf("\n5. %s", this.map.get("save"));
            System.out.printf("\n6. %s", this.map.get("lang"));
            System.out.printf("\n7. %s", this.map.get("exit"));
            System.out.printf("\n%s", this.map.get("choose"));
            int c = Integer.parseInt(input.nextLine());
            
            switch (c) {
                case 1:
                    stm.add(input, arr);
                    break;
                case 2:
                    stm.search(arr, input.nextLine());
                    break;
                case 3:
                    stm.update(arr, input.nextLine(), Integer.parseInt(input.nextLine()));
                    break;
                case 4:
                    stm.delete(arr, input.nextLine());
                    break;
                case 5:
                    stm.save(arr);
                    break;
                case 6:
                    System.out.print(this.map.get("mess"));
                    int la = Integer.parseInt(input.nextLine());
                    if (la == 1)
                        this.loadData("En");
                    else if (la == 2)
                        this.loadData("Vi");
                    break;
                case 7:
                    stm.show(arr);
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not valid");
            }
        }

    }
}
