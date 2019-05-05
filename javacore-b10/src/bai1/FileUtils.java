/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.File;
import java.io.FileFilter;
import java.util.Date;

/**
 *
 * @author oo
 */
public class FileUtils {

    public void folder(String path) {
        File f = new File(path);
        File[] folders = f.listFiles();
        for (File folder : folders) {
            if (folder.isDirectory()) {
                System.out.println(folder);
            }
        }
    }

    public void file(String path) {
        File f = new File(path);
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file);
            }
        }
    }

    private class filefilter implements FileFilter {

        @Override
        public boolean accept(File file) {

            if (file.getAbsolutePath().endsWith(".jpg")) {
                return true;
            }
            if (file.getAbsolutePath().endsWith(".jpeg")) {
                return true;
            }
            if (file.getAbsolutePath().endsWith(".png")) {
                return true;
            }
            return false;
        }

    }

    public void fileAnh(String path) {
        File f = new File(path);
        File[] fileimg = f.listFiles(new filefilter());
        for (File file : fileimg) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public void fileExt(String ext, String path) {
        File f = new File(path);
        File[] fileext = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.getAbsolutePath().endsWith(ext)) {
                    return true;
                }
                return false;
            }
        });
        for (File file : fileext) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public void fileSize(String path) {
        File f = new File(path);
        long lastMofifyInMillis = f.lastModified(); // milliseconds
        Date lastModifyDate = new Date(lastMofifyInMillis);
        System.out.println("Last modify date: " + lastModifyDate);
    }

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        fileUtils.fileSize("C:\\Users\\oo\\Desktop\\lập trình web\\lập trình web");
    }
}
