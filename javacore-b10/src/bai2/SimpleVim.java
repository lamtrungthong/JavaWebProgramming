/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author oo
 */
public class SimpleVim {

    public void createNewFile(String path) throws IOException {
        File f = new File(path);
        if (f.exists()) {
            System.out.println(f.getPath());
        } else {
            f.createNewFile();
        }
    }

    public void writeFile(String path, Scanner sc) {
        String text = "";
        String s;
        do {
            s = sc.nextLine();
            text += s + "\r\n";
            if (s.equals(":q")) {
                break;
            } else if (s.equals(":wq")) {
                try {
                    FileWriter fw = new FileWriter(new File(path));
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.append(text);
                    bw.newLine();
                    bw.close();
                    fw.close();
                } catch (Exception e) {
                }
                break;
            }
        } while (true);
    }

    public void readFile(String path) {
        try {
            FileReader fr = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            while (s!= null) {                
                System.out.println(s);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        SimpleVim sv = new SimpleVim();
        Scanner sc = new Scanner(System.in);
        sv.writeFile("C:\\Users\\oo\\Desktop\\Web\\testSimpleVim.txt", sc);
        sv.readFile("C:\\Users\\oo\\Desktop\\Web\\testSimpleVim.txt");
    }
}
