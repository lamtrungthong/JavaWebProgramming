/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dto;

import java.util.Date;

/**
 *
 * @author thonglt
 */
public class ProdAndDeltail {

    private int id;
    private String name;
    private int kind_id;
    private int quantityStore;
    private int priceStore;
    private int price;
    private int discount;
    private String description;
    private String images;
    private int actived;
    private int sell;
    private Date createdAt;
    private Date updatedAt;
    private double display;
    private String OS;
    private int ram;
    private int rom;
    private int fCamera;
    private int bCamera;
    private int battery;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }

    public int getQuantityStore() {
        return quantityStore;
    }

    public void setQuantityStore(int quantityStore) {
        this.quantityStore = quantityStore;
    }

    public int getPriceStore() {
        return priceStore;
    }

    public void setPriceStore(int priceStore) {
        this.priceStore = priceStore;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getActived() {
        return actived;
    }

    public void setActived(int actived) {
        this.actived = actived;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
