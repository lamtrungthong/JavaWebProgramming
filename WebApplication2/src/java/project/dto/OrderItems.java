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
public class OrderItems {
    private  int id ;
    private String orderId ;
    private int prodId ;
    private String color ;
    private int amount ;
    private int quantity ;

    private Products prod;
            
    public OrderItems() {
    }

    public OrderItems(int id, String orderId, int prodId, String color, int amount, int quantity, Products prod) {
        this.id = id;
        this.orderId = orderId;
        this.prodId = prodId;
        this.color = color;
        this.amount = amount;
        this.quantity = quantity;
        this.prod = prod;
    }

    

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProd() {
        return prod;
    }

    public void setProd(Products prod) {
        this.prod = prod;
    }
    
    
}
