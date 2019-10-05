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
public class Orders {
    private String id ;
    private String userId ;
    private int payId ;
    private int orderStatus ;
    private Date orderedAt ;
    private Date updatetAt ;
    private OrderStatus os;
    private List<OrderItems> orderItems;
    private Users users;
    
    public Orders() {
    }

    public Orders(String id, String userId, int payId,int orderStatus, Date orderedAt, Date updatetAt) {
        this.id = id;
        this.userId = userId;
        this.payId = payId;
        this.orderStatus = orderStatus;
        this.orderedAt = orderedAt;
        this.updatetAt = updatetAt;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    
    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderStatus getOs() {
        return os;
    }

    public void setOs(OrderStatus os) {
        this.os = os;
    }
    

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public Date getUpdatetAt() {
        return updatetAt;
    }

    public void setUpdatetAt(Date updatetAt) {
        this.updatetAt = updatetAt;
    }
    
    
}
