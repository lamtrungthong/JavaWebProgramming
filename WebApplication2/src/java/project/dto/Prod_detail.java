/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dto;

/**
 *
 * @author thonglt
 */
public class Prod_detail {

    private int id;
    private int prodId;
    private double display;
    private String OS;
    private int ram;
    private int rom;
    private int fCamera;
    private int bCamera;
    private int battery;

    public Prod_detail() {
    }

    public Prod_detail(int id, int prodId, double display, String OS, int ram, int rom, int fCamera, int bCamera, int battery) {
        this.id = id;
        this.prodId = prodId;
        this.display = display;
        this.OS = OS;
        this.ram = ram;
        this.rom = rom;
        this.fCamera = fCamera;
        this.bCamera = bCamera;
        this.battery = battery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public double getDisplay() {
        return display;
    }

    public void setDisplay(double display) {
        this.display = display;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getfCamera() {
        return fCamera;
    }

    public void setfCamera(int fCamera) {
        this.fCamera = fCamera;
    }

    public int getbCamera() {
        return bCamera;
    }

    public void setbCamera(int bCamera) {
        this.bCamera = bCamera;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    
}
