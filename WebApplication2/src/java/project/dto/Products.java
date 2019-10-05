/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author thonglt
 */
public class Products {

    private int id;
    private String name;
    private int kind_id;
    private int quantityStore ;
    private int priceStore ;
    private int price;
    private int discount;
    private String description;
    private String images;
    private int actived;
    private int sell; 
    private Date createdAt;
    private Date updatedAt;

    private List<Prod_images> listImg ;
    public Products() {
    }

    public Products(int id, String name, int kind_id, int quantityStore, int priceStore, int price, int discount, String description, String images, int actived, int sell, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.kind_id = kind_id;
        this.quantityStore = quantityStore;
        this.priceStore = priceStore;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.images = images;
        this.actived = actived;
        this.sell = sell;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public List<Prod_images> getListImg() {
        return listImg;
    }

    public void setListImg(List<Prod_images> listImg) {
        this.listImg = listImg;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
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

    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", name=" + name + ", kind_id=" + kind_id + ", price=" + price + ", description=" + description + ", images=" + images + ", actived=" + actived + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    
    
    
}
