/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author oo
 */
public class TaskManager {

    ArrayList<Task> arr = new ArrayList<>();

    public void add(Task task) {
        task = new Task(1, "1", "A", true);
        add(task);
        task = new Task(2, "2", "B", false);
        add(task);
        task = new Task(3, "3", "C", true);
        add(task);

        try {
            String path = "C:\\Users\\oo\\Desktop\\Web\\task.txt";
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            for (Task task1 : arr) {
                oos.writeObject(task1);
                oos.flush();
            }
            oos.close();
        } catch (Exception e) {
        }
    }//task được thêm vào mảng và ghi vào file

  public void showAll() {
        for (Task task : arr) {
            System.out.println("ID: " + task.getId());
            System.out.println("Title: " + task.getTitle());
            System.out.println("Content: " + task.getContent());
            System.out.println("Done: " + task.isDone());
        }
    }// hiển thị danh sách tất cả các task trong mảng

    void showDone(boolean isDone) {

        for (Task task : arr) {
            if (isDone == task.isDone()) {
                System.out.println("List Done.");
                System.out.println("ID: " + task.getId());
                System.out.println("Title: " + task.getTitle());
                System.out.println("Content: " + task.getContent());
                System.out.println("Done: " + task.isDone());
            }
            if (isDone == task.isDone()) {
                System.out.println("List not Done.");
                System.out.println("ID: " + task.getId());
                System.out.println("Title: " + task.getTitle());
                System.out.println("Content: " + task.getContent());
                System.out.println("Done: " + task.isDone());
            }
        }
    }//hiển thị task đã done hoặc chưa done

    public void load(String path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Task task = (Task) ois.readObject();
            arr.add(task);
            ois.close();
        } catch (Exception e) {
        }
    }// đọc file, load dữ liệu task vào mảng

    public void updateStatus(int id, boolean done) {
        for(Task task : arr){
            if(task.getId() == id )
                task.setDone(done);
        }
    }
// cập nhật trạng thái hoàn thành cho task
}
